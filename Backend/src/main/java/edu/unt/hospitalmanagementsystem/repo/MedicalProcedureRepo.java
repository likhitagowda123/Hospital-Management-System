package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalProcedureRepo extends JpaRepository<MedicalProcedure, Long> {
}
