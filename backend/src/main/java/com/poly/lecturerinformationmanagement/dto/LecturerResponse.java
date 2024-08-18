package com.poly.lecturerinformationmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LecturerResponse {
    private Long id;
    private String idLecturer;
    private String firstName;
    private String lastName;
    private String lecturerType;
    private String educationLevel;
    private String lecturerImage;
    private BigDecimal baseSalary;
    private LocalDate startDate;
    private String email;
    private String phoneNumber;
    private String department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(String idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLecturerType() {
        return lecturerType;
    }

    public void setLecturerType(String lecturerType) {
        this.lecturerType = lecturerType;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getLecturerImage() {
        return lecturerImage;
    }

    public void setLecturerImage(String lecturerImage) {
        this.lecturerImage = lecturerImage;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
