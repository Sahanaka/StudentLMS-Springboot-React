package com.example.studentlms.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void registerNewStudent(Student student) {
        Student existingStudent = studentRepository.findStudentByEmail(student.getEmail());
        if (existingStudent != null) {
            throw new IllegalStateException("Invalid Email!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Invalid ID!");
        }
        studentRepository.deleteById(id);
    }
}
