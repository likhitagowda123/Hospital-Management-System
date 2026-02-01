package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreatmentRepo extends JpaRepository<Treatment, Long> {
    List<Treatment> findByProcedureId(Long procedureId);

    List<Treatment> getTreatmentsByBillingId(Long id);
}
