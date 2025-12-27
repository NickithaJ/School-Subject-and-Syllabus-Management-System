package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(long id) {
        return courseRepo.findById(id).orElse(null);
    }

    public Course updateCourse(long id, Course course) {
        course.setCourseId(id);
        return courseRepo.save(course);
    }
    public List<Course> getCoursesByInstructor(long instructorId) {
        return courseRepo.findByInstructor_InstructorId(instructorId);
    }

    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }
}


