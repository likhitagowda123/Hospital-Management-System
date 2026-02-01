package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.entity.Doctor;
import edu.unt.hospitalmanagementsystem.entity.DoctorSpecialization;

import java.util.List;

public interface DoctorService {

    List<Doctor> listAllDoctors();

    Doctor addDoctor(Doctor doctor);

    Doctor updateDoctor(Doctor doctor);

    String deleteDoctor(Long doctorId);

    Doctor getDoctorById(Long doctorId);

    List<DoctorSpecialization> listAllDoctorSpecialization();

    long countAllDoctors();
}
