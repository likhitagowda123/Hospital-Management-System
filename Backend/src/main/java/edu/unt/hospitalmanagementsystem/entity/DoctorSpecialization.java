package edu.unt.hospitalmanagementsystem.entity;

import jakarta.persistence.*;

@Entity(name = "doctor_specialization")
public class DoctorSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private Long id;

    @Column(name = "specialization_name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
