package com.example.studentlms.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentManagementService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    public ResponseEntity<String> registerNewStudent(Student student) {
        if (student.equals(null)) {
            return ResponseEntity.badRequest().body("Please Validate your input!");
        }
        Student existingStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (existingStudent != null) {
            return ResponseEntity.badRequest().body("Invalid Email");
        }
        try {
            studentRepository.save(student);
            return ResponseEntity.ok("New Student Created");
        }
        catch (Exception ex) { return ResponseEntity.internalServerError().body("Server Error!" + ex.toString()); }
    }

    public ResponseEntity<String> deleteStudent(String id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            return ResponseEntity.badRequest().body("Invalid ID!");
        }
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Deleted student with ID: " + id);
        }
        catch (Exception ex) { return ResponseEntity.internalServerError().body("Server Error!" + ex.toString()); }
    }
}
