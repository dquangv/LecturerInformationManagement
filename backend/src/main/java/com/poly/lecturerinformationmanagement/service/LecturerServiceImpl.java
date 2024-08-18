package com.poly.lecturerinformationmanagement.service;

import com.poly.lecturerinformationmanagement.dto.LecturerResponse;
import com.poly.lecturerinformationmanagement.exception.LecturerNotFoundException;
import com.poly.lecturerinformationmanagement.model.EducationLevel;
import com.poly.lecturerinformationmanagement.model.Lecturer;
import com.poly.lecturerinformationmanagement.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;
//    private List<Lecturer> byEducationLevelAndSearchTerm;

//    @Override
//    public Lecturer addLecturer(Lecturer lecturer) {
//        return lecturerRepository.save(lecturer);
//    }

    @Override
    public LecturerResponse addLecturer(Lecturer lecturer) {
        Lecturer savedLecturer = lecturerRepository.save(lecturer);
        return LecturerMapper.toLecturerResponse(savedLecturer);
    }

//    @Override
//    public Lecturer updateLecturer(Lecturer lecturer, Long id) {
//        return lecturerRepository.findById(id).map(lc -> {
//            lc.setIdLecturer(lecturer.getIdLecturer());
//            lc.setFirstName(lecturer.getFirstName());
//            lc.setLastName(lecturer.getLastName());
//            lc.setLecturerType(lecturer.getLecturerType());
//            lc.setEducationLevel(lecturer.getEducationLevel());
//            lc.setLecturerImage(lecturer.getLecturerImage());
//            lc.setBaseSalary(lecturer.getBaseSalary());
//            lc.setStartDate(lecturer.getStartDate());
//            lc.setEmail(lecturer.getEmail());
//            lc.setPhoneNumber(lecturer.getPhoneNumber());
//            lc.setDepartment(lecturer.getDepartment());
//            return lecturerRepository.save(lc);
//        }).orElseThrow(() -> new LecturerNotFoundException("Sorry, this lecturer could not be found"));
//    }

    @Override
    public LecturerResponse updateLecturer(Lecturer lecturer, Long id) {
        return lecturerRepository.findById(id).map(lc -> {
            lc.setIdLecturer(lecturer.getIdLecturer());
            lc.setFirstName(lecturer.getFirstName());
            lc.setLastName(lecturer.getLastName());
            lc.setLecturerType(lecturer.getLecturerType());
            lc.setEducationLevel(lecturer.getEducationLevel());
            lc.setLecturerImage(lecturer.getLecturerImage());
            lc.setBaseSalary(lecturer.getBaseSalary());
            lc.setStartDate(lecturer.getStartDate());
            lc.setEmail(lecturer.getEmail());
            lc.setPhoneNumber(lecturer.getPhoneNumber());
            lc.setDepartment(lecturer.getDepartment());
            Lecturer updatedLecturer = lecturerRepository.save(lc);
            return LecturerMapper.toLecturerResponse(updatedLecturer);
        }).orElseThrow(() -> new LecturerNotFoundException("Sorry, this lecturer could not be found"));
    }

//    @Override
//    public Lecturer getLecturerById(Long id) {
//        return lecturerRepository.findById(id).orElseThrow(() -> new LecturerNotFoundException("Sorry, no lecturer found with the Id: " + id));
//    }

    @Override
    public LecturerResponse getLecturerById(Long id) {
        Lecturer lecturer = lecturerRepository.findById(id).orElseThrow(() -> new LecturerNotFoundException("Sorry, no lecturer found with the Id: " + id));
        return LecturerMapper.toLecturerResponse(lecturer);
    }

//    @Override
//    public List<Lecturer> getAllLecturers() {
//        return lecturerRepository.findAll();
//    }

    @Override
    public List<LecturerResponse> getAllLecturers() {
        List<Lecturer> lecturers = lecturerRepository.findAll();
        return lecturers.stream()
                .map(LecturerMapper::toLecturerResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Lecturer> getLecturersByEducationLevel(EducationLevel educationLevel) {
//        return lecturerRepository.findByEducationLevel(educationLevel);
//    }

    @Override
    public List<LecturerResponse> getLecturersByEducationLevel(EducationLevel educationLevel) {
        List<Lecturer> lecturers = lecturerRepository.findByEducationLevel(educationLevel);
        return lecturers.stream()
                .map(LecturerMapper::toLecturerResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Lecturer> findByEducationLevelAndSearchTerm(EducationLevel educationLevel, String searchTerm) {
//        return lecturerRepository.findByEducationLevelAndSearchTerm(educationLevel, searchTerm);
//    }

    @Override
    public List<LecturerResponse> findByEducationLevelAndSearchTerm(EducationLevel educationLevel, String searchTerm) {
        List<Lecturer> lecturers = lecturerRepository.findByEducationLevelAndSearchTerm(educationLevel, searchTerm);
        return lecturers.stream()
                .map(LecturerMapper::toLecturerResponse)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Lecturer> searchLecturers(String searchTerm) {
//        if (searchTerm == null || searchTerm.isEmpty()) {
//            return lecturerRepository.findAll();
//        } else {
//            return lecturerRepository.searchLecturers(searchTerm);
//        }
//    }


}
