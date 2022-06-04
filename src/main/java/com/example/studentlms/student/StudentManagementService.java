package com.example.studentlms.student;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentManagementService {
    ResponseEntity<List<Student>> getStudents();

    ResponseEntity<String> registerNewStudent(Student student);

    ResponseEntity<String> deleteStudent(String id);
}
