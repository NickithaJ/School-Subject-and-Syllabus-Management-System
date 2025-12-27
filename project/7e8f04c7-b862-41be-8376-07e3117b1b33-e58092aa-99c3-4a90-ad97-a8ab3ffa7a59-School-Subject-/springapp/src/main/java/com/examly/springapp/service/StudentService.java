package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(long id, Student student) {
        Student existing = studentRepo.findById(id).orElse(null);

        existing.setStudentName(student.getStudentName());
        existing.setEmail(student.getEmail());
        existing.setPhoneNumber(student.getPhoneNumber());
        existing.setAddress(student.getAddress());

        return studentRepo.save(existing);
    }
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email).orElse(null);
    }
}
