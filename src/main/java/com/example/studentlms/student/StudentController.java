package com.example.studentlms.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {

    private final StudentManagementService studentService;

    @Autowired
    public StudentController(StudentManagementService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<String> registerNewStudent(@RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") String id) {
        return studentService.deleteStudent(id);
    }
}
