package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
    @Id
    private long instructorId;
    private String instructorName;
    private String specialization;
    private String phoneNumber;
    public Enrollment(long instructorId, String instructorName, String specialization, String phoneNumber) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }
    public Enrollment() {
    }
    public long getInstructorId() {
        return instructorId;
    }
    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }
    public String getInstructorName() {
        return instructorName;
    }
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
