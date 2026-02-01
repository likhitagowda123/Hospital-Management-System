package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepo extends JpaRepository<Billing, Long> {
    List<Billing> getBillingByPatientId(Long patientId);
}
