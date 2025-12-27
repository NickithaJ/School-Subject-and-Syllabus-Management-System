package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    public Instructor getInstructorById(long id) {
        return instructorRepo.findById(id).orElse(null);
    }

    public Instructor updateInstructor(long id, Instructor instructor) {
        instructor.setInstructorId(id);
        return instructorRepo.save(instructor);
    }
    public void deleteInstructor(long id) {
        instructorRepo.deleteById(id);
    }

    public Page<Instructor> getInstructors(Pageable pageable) {
        return instructorRepo.findAll(pageable);
    }
    public List<Instructor> getInstructorBySpecialization(String specialization) {
        return instructorRepo.findBySpecialization(specialization);
    }
}

