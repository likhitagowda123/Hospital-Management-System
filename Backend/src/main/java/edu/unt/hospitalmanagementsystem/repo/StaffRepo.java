package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
