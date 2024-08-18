package com.poly.lecturerinformationmanagement.repository;

import com.poly.lecturerinformationmanagement.model.EducationLevel;
import com.poly.lecturerinformationmanagement.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    List<Lecturer> findByEducationLevel(EducationLevel educationLevel);

//    @Query("SELECT l FROM Lecturer l WHERE " +
//            "(:searchTerm IS NULL OR :searchTerm = '' OR l.idLecturer LIKE %:searchTerm% OR " +
//            "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
//            "LOWER(l.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
//    List<Lecturer> searchLecturers(@Param("searchTerm") String searchTerm);

//    @Query("SELECT l FROM Lecturer l WHERE " +
//            "(:educationLevel IS NULL OR l.educationLevel = :educationLevel) AND " +
//            "(:searchTerm IS NULL OR :searchTerm = '' OR " +
//            "l.idLecturer LIKE %:searchTerm% OR " +
//            "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
//            "LOWER(l.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
//    List<Lecturer> findByEducationLevelAndSearchTerm(
//            @Param("educationLevel") EducationLevel educationLevel,
//            @Param("searchTerm") String searchTerm
//    );

//    @Query("SELECT l FROM Lecturer l WHERE " +
//            "(:educationLevel IS NULL OR l.educationLevel = :educationLevel) AND " +
//            "(COALESCE(:searchTerm, '') = '' OR " +
//            "l.idLecturer LIKE %:searchTerm% OR " +
//            "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
//            "LOWER(l.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) " +
//            "OR (:educationLevel IS NULL AND COALESCE(:searchTerm, '') = '')")
//    List<Lecturer> findByEducationLevelAndSearchTerm(
//            @Param("educationLevel") EducationLevel educationLevel,
//            @Param("searchTerm") String searchTerm
//    );

//    @Query("SELECT l FROM Lecturer l WHERE " +
//            "(:educationLevel IS NULL OR l.educationLevel = :educationLevel) AND " +
//            "(COALESCE(:searchTerm, '') = '' OR " +
//            "l.idLecturer LIKE %:searchTerm% OR " +
//            "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
//            "LOWER(l.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
//    List<Lecturer> findByEducationLevelAndSearchTerm(
//            @Param("educationLevel") EducationLevel educationLevel,
//            @Param("searchTerm") String searchTerm
//    );

    @Query("SELECT l FROM Lecturer l WHERE " +
            "(:educationLevel IS NULL OR l.educationLevel = :educationLevel) AND " +
            "(:searchTerm = '' OR " +
            "l.idLecturer LIKE %:searchTerm% OR " +
            "LOWER(l.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(l.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%')))")
    List<Lecturer> findByEducationLevelAndSearchTerm(
            @Param("educationLevel") EducationLevel educationLevel,
            @Param("searchTerm") String searchTerm
    );
}
