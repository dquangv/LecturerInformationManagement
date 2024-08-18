package com.poly.lecturerinformationmanagement.controller;

import com.poly.lecturerinformationmanagement.dto.LecturerResponse;
import com.poly.lecturerinformationmanagement.model.Department;
import com.poly.lecturerinformationmanagement.model.EducationLevel;
import com.poly.lecturerinformationmanagement.model.Lecturer;
import com.poly.lecturerinformationmanagement.model.LecturerType;
import com.poly.lecturerinformationmanagement.repository.LecturerRepository;
import com.poly.lecturerinformationmanagement.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/lecturers")
@CrossOrigin
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

//    @PostMapping("/add")
//    public Lecturer addLecturer(@RequestBody Lecturer lecturer) {
//        return lecturerService.addLecturer(lecturer);
//    }

//    @PostMapping("/add")
//    public Lecturer addLecturer(
//            @RequestParam("idLecturer") String idLecturer,
//            @RequestParam("firstName") String firstName,
//            @RequestParam("lastName") String lastName,
//            @RequestParam("lecturerType") LecturerType lecturerType,
//            @RequestParam("educationLevel") EducationLevel educationLevel,
//            @RequestParam(value = "file", required = false) MultipartFile file, // File upload
//            @RequestParam("baseSalary") BigDecimal baseSalary,
//            @RequestParam(value = "startDate", required = false) String startDate, // Date as string
//            @RequestParam("email") String email,
//            @RequestParam("phoneNumber") String phoneNumber,
//            @RequestParam("department") String department) {
//
//        // Handle the file upload
//        String fileName = handleFileUpload(file);
//
//        // Create Lecturer object
//        Lecturer lecturer = new Lecturer();
//        lecturer.setIdLecturer(idLecturer);
//        lecturer.setFirstName(firstName);
//        lecturer.setLastName(lastName);
//        lecturer.setLecturerType(lecturerType);
//        lecturer.setEducationLevel(educationLevel);
//        lecturer.setLecturerImage(fileName); // Set the file name here
//        lecturer.setBaseSalary(baseSalary);
//        lecturer.setStartDate(startDate != null ? LocalDate.parse(startDate) : null);
//        lecturer.setEmail(email);
//        lecturer.setPhoneNumber(phoneNumber);
//        lecturer.setDepartment(department);
//
//        // Call the service to save the lecturer
//        return lecturerService.addLecturer(lecturer);
//    }

    @PostMapping("/add")
    public LecturerResponse addLecturer(
            @RequestParam("idLecturer") String idLecturer,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("lecturerType") LecturerType lecturerType,
            @RequestParam("educationLevel") EducationLevel educationLevel,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("baseSalary") BigDecimal baseSalary,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("department") Department department) {

        String fileName = handleFileUpload(file);

        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecturer(idLecturer);
        lecturer.setFirstName(firstName);
        lecturer.setLastName(lastName);
        lecturer.setLecturerType(lecturerType);
        lecturer.setEducationLevel(educationLevel);
        lecturer.setLecturerImage(fileName);
        lecturer.setBaseSalary(baseSalary);
        lecturer.setStartDate(startDate != null ? LocalDate.parse(startDate) : null);
        lecturer.setEmail(email);
        lecturer.setPhoneNumber(phoneNumber);
        lecturer.setDepartment(department);

        return lecturerService.addLecturer(lecturer);
    }

//    @PutMapping("/update/{id}")
//    public Lecturer updateLecturer(@RequestBody Lecturer lecturer, @PathVariable Long id) {
//        return lecturerService.updateLecturer(lecturer, id);
//    }

//    @PutMapping("/update/{id}")
//    public Lecturer updateLecturer(
//            @PathVariable Long id,
//            @RequestParam("idLecturer") String idLecturer,
//            @RequestParam("firstName") String firstName,
//            @RequestParam("lastName") String lastName,
//            @RequestParam("lecturerType") LecturerType lecturerType,
//            @RequestParam("educationLevel") EducationLevel educationLevel,
//            @RequestParam(value = "file", required = false) MultipartFile file, // File upload
//            @RequestParam("baseSalary") BigDecimal baseSalary,
//            @RequestParam(value = "startDate", required = false) String startDate, // Date as string
//            @RequestParam("email") String email,
//            @RequestParam("phoneNumber") String phoneNumber,
//            @RequestParam("department") String department) {
//
//        // Handle the file upload
//        String fileName = handleFileUpload(file);
//
//        // Retrieve the existing lecturer from the database
//        Lecturer lecturer = lecturerService.getLecturerById(id);
//
//        // Update the lecturer object with new values
//        lecturer.setIdLecturer(idLecturer);
//        lecturer.setFirstName(firstName);
//        lecturer.setLastName(lastName);
//        lecturer.setLecturerType(lecturerType);
//        lecturer.setEducationLevel(educationLevel);
//
//        // Update the image file name if a new file is uploaded
//        if (fileName != null) {
//            lecturer.setLecturerImage(fileName);
//        }
//
//        lecturer.setBaseSalary(baseSalary);
//        lecturer.setStartDate(startDate != null ? LocalDate.parse(startDate) : null);
//        lecturer.setEmail(email);
//        lecturer.setPhoneNumber(phoneNumber);
//        lecturer.setDepartment(department);
//
//        // Call the service to update the lecturer
//        return lecturerService.updateLecturer(lecturer, id);
//    }

    @PutMapping("/update/{id}")
    public LecturerResponse updateLecturer(
            @PathVariable Long id,
            @RequestParam("idLecturer") String idLecturer,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("lecturerType") LecturerType lecturerType,
            @RequestParam("educationLevel") EducationLevel educationLevel,
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("baseSalary") BigDecimal baseSalary,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("department") Department department) {

        String fileName = handleFileUpload(file);

        Lecturer lecturer = getLecturer(id);

        lecturer.setIdLecturer(idLecturer);
        lecturer.setFirstName(firstName);
        lecturer.setLastName(lastName);
        lecturer.setLecturerType(lecturerType);
        lecturer.setEducationLevel(educationLevel);
        if (fileName != null) {
            lecturer.setLecturerImage(fileName);
        }
        lecturer.setBaseSalary(baseSalary);
        lecturer.setStartDate(startDate != null ? LocalDate.parse(startDate) : null);
        lecturer.setEmail(email);
        lecturer.setPhoneNumber(phoneNumber);
        lecturer.setDepartment(department);

        return lecturerService.updateLecturer(lecturer, id);
    }

//    @GetMapping("/{id}")
//    public Lecturer getLecturer(@PathVariable Long id) {
//        return lecturerService.getLecturerById(id);
//    }

    @GetMapping("/{id}")
    public Lecturer getLecturer(@PathVariable Long id) {
        LecturerResponse lecturerResponse = lecturerService.getLecturerById(id);
        return convertToLecturer(lecturerResponse);
    }

//    @GetMapping("/getAll")
//    public List<Lecturer> getAllLecturers() {
//        return lecturerService.getAllLecturers();
//    }

    @GetMapping("/getAll")
    public List<LecturerResponse> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }

//    @GetMapping("/filter")
//    public List<Lecturer> getLecturersByEducationLevel(@RequestParam EducationLevel educationLevel) {
//        return lecturerService.getLecturersByEducationLevel(educationLevel);
//    }

//    @GetMapping("/search")
//    public List<Lecturer> searchLecturers(@RequestParam(required = false) String searchTerm) {
//        return lecturerService.searchLecturers(searchTerm);
//    }

//    @GetMapping("/filterByEducationLevel")
//    public List<Lecturer> filterLecturersByEducationLevel(@RequestParam EducationLevel educationLevel) {
//        return lecturerService.getLecturersByEducationLevel(educationLevel);
//    }

    @GetMapping("/filter")
    public List<LecturerResponse> getLecturersByEducationLevel(@RequestParam EducationLevel educationLevel) {
        return lecturerService.getLecturersByEducationLevel(educationLevel);
    }

//    @GetMapping("/filterAndSearch")
//    public List<Lecturer> filterAndSearchLecturers(
//            @RequestParam(required = false) EducationLevel educationLevel,
//            @RequestParam(required = false) String searchTerm
//    ) {
//        return lecturerService.findByEducationLevelAndSearchTerm(educationLevel, searchTerm);
//    }

    @GetMapping("/filterAndSearch")
    public List<LecturerResponse> filterAndSearchLecturers(
            @RequestParam(required = false) EducationLevel educationLevel,
            @RequestParam(required = false) String searchTerm) {
        return lecturerService.findByEducationLevelAndSearchTerm(educationLevel, searchTerm);
    }

    private String handleFileUpload(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String absolutePath = new File("").getAbsolutePath();

                String directoryPath = absolutePath + "/src/main/resources/static/img/";
                File directory = new File(directoryPath);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String filePath = directoryPath + file.getOriginalFilename();
                File destFile = new File(filePath);

                if (destFile.exists()) {
                    return file.getOriginalFilename();
                } else {
                    file.transferTo(destFile);
                    return file.getOriginalFilename();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Lecturer convertToLecturer(LecturerResponse lecturerResponse) {
        Lecturer lecturer = new Lecturer();

        lecturer.setId(lecturerResponse.getId());
        lecturer.setIdLecturer(lecturerResponse.getIdLecturer());
        lecturer.setFirstName(lecturerResponse.getFirstName());
        lecturer.setLastName(lecturerResponse.getLastName());

        lecturer.setLecturerType(LecturerType.valueOf(lecturerResponse.getLecturerType()));

        lecturer.setEducationLevel(EducationLevel.fromDisplayName(lecturerResponse.getEducationLevel()));

        lecturer.setDepartment(Department.fromDisplayName(lecturerResponse.getDepartment()));

        lecturer.setLecturerImage(lecturerResponse.getLecturerImage());
        lecturer.setBaseSalary(lecturerResponse.getBaseSalary());
        lecturer.setStartDate(lecturerResponse.getStartDate());
        lecturer.setEmail(lecturerResponse.getEmail());
        lecturer.setPhoneNumber(lecturerResponse.getPhoneNumber());


        return lecturer;
    }
}
