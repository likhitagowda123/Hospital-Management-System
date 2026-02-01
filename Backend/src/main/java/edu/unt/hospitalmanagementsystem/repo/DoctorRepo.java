package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
