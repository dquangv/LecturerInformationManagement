package com.poly.lecturerinformationmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idLecturer;
    private String firstName;
    private String lastName;
    private LecturerType lecturerType;
    private EducationLevel educationLevel;
    private String lecturerImage;
    private BigDecimal baseSalary;
    private LocalDate startDate;
    private String email;
    private String phoneNumber;
    private Department department;

    public Lecturer(String idLecturer, String firstName, String lastName, LecturerType lecturerType, EducationLevel educationLevel, String lecturerImage, BigDecimal baseSalary, LocalDate startDate, String email, String phoneNumber, Department department) {
        this.idLecturer = idLecturer;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lecturerType = lecturerType;
        this.educationLevel = educationLevel;
        this.lecturerImage = lecturerImage;
        this.baseSalary = baseSalary;
        this.startDate = startDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", idLecturer='" + idLecturer + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lecturerType=" + lecturerType +
                ", educationLevel=" + educationLevel +
                ", lecturerImage='" + lecturerImage + '\'' +
                ", baseSalary=" + baseSalary +
                ", startDate=" + startDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(String idLecturer) {
        this.idLecturer = idLecturer;
    }

    public String getLecturerImage() {
        return lecturerImage;
    }

    public void setLecturerImage(String lecturerImage) {
        this.lecturerImage = lecturerImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LecturerType getLecturerType() {
        return lecturerType;
    }

    public void setLecturerType(LecturerType lecturerType) {
        this.lecturerType = lecturerType;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
