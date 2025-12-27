package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.saveInstructor(instructor), HttpStatus.CREATED);
    }

@GetMapping
public ResponseEntity<List<Instructor>> getAllInstructors() {
    List<Instructor> instructors = instructorService.getAllInstructors();
    if (instructors.isEmpty()) {
        return ResponseEntity.noContent().build(); 
    }
    return ResponseEntity.ok(instructors);
}

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable long id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable long id,
            @RequestBody Instructor instructor) {
        return ResponseEntity.ok(instructorService.updateInstructor(id, instructor));
    }
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteInstructor(@PathVariable long id) {
    instructorService.deleteInstructor(id);
    return ResponseEntity.noContent().build();
}

    @GetMapping("/page/{page}/{size}")
    public Page<Instructor> getInstructorsWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("instructorId"));
        return instructorService.getInstructors(pageable);
    }
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<?> getInstructorBySpecialization(@PathVariable String specialization) {

        List<Instructor> instructors = instructorService.getInstructorBySpecialization(specialization);

        if (instructors.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No instructors found with specialization: " + specialization);
        }
        return ResponseEntity.ok(instructors);
    }
}

