package com.example.studentlms.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{ 'email' : ?0 }")
    Student findStudentByEmail(String email);
}
