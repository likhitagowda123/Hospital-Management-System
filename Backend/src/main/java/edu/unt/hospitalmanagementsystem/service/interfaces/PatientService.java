package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> listAllPatients();

    Patient addPatient(Patient patient);

    Patient getPatientById(Long patientId);

    Patient updatePatient(Patient patient);

    String deletePatient(Long patientId);
}
