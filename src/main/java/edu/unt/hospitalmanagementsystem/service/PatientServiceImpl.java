package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.repo.PatientRepo;
import edu.unt.hospitalmanagementsystem.service.interfaces.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    @Override
    public List<Patient> listAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        Optional<Patient> patientResult = patientRepo.findById(patientId);

        Patient patient = null;
        if (patientResult.isPresent()) {
            patient = patientResult.get();
        }

        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public String deletePatient(Long patientId) {
        Optional<Patient> patientResult = patientRepo.findById(patientId);

        if (patientResult.isPresent()) {
            patientRepo.delete(patientResult.get());
            return "Success";
        } else {
            throw new IllegalStateException("Failed to delete. Please try again");
        }
    }
}
