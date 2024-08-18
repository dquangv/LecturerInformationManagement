package com.poly.lecturerinformationmanagement.service;

import com.poly.lecturerinformationmanagement.dto.LecturerResponse;
import com.poly.lecturerinformationmanagement.model.Lecturer;

public class LecturerMapper {
    public static LecturerResponse toLecturerResponse(Lecturer lecturer) {
        LecturerResponse response = new LecturerResponse();

        response.setId(lecturer.getId());
        response.setIdLecturer(lecturer.getIdLecturer());
        response.setFirstName(lecturer.getFirstName());
        response.setLastName(lecturer.getLastName());
        response.setLecturerType(lecturer.getLecturerType().getDisplayName());
        response.setEducationLevel(lecturer.getEducationLevel().getDisplayName());
        response.setLecturerImage(lecturer.getLecturerImage());
        response.setBaseSalary(lecturer.getBaseSalary());
        response.setStartDate(lecturer.getStartDate());
        response.setEmail(lecturer.getEmail());
        response.setPhoneNumber(lecturer.getPhoneNumber());
        response.setDepartment(lecturer.getDepartment().getDisplayName());
        return response;
    }
}
