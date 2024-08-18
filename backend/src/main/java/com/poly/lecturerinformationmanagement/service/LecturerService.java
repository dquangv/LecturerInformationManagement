package com.poly.lecturerinformationmanagement.service;

import com.poly.lecturerinformationmanagement.dto.LecturerResponse;
import com.poly.lecturerinformationmanagement.model.EducationLevel;
import com.poly.lecturerinformationmanagement.model.Lecturer;

import java.util.List;

public interface LecturerService {
//    public Lecturer addLecturer(Lecturer lecturer);
//
//    public Lecturer updateLecturer(Lecturer lecturer, Long id);
//
//    public Lecturer getLecturerById(Long id);
//
//    public List<Lecturer> getAllLecturers();
//
//    public List<Lecturer> getLecturersByEducationLevel(EducationLevel educationLevel);
//
//    public List<Lecturer> findByEducationLevelAndSearchTerm(EducationLevel educationLevel, String searchTerm);

//    public List<Lecturer> searchLecturers(String searchTerm);

    public LecturerResponse addLecturer(Lecturer lecturer);

    public LecturerResponse updateLecturer(Lecturer lecturer, Long id);

    public LecturerResponse getLecturerById(Long id);

    public List<LecturerResponse> getAllLecturers();

    public List<LecturerResponse> getLecturersByEducationLevel(EducationLevel educationLevel);

    public List<LecturerResponse> findByEducationLevelAndSearchTerm(EducationLevel educationLevel, String searchTerm);
}
