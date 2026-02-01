package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.entity.Doctor;
import edu.unt.hospitalmanagementsystem.entity.DoctorSpecialization;
import edu.unt.hospitalmanagementsystem.repo.DoctorRepo;
import edu.unt.hospitalmanagementsystem.repo.DoctorSpecializationRepo;
import edu.unt.hospitalmanagementsystem.service.interfaces.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepo doctorRepo;

    private DoctorSpecializationRepo doctorSpecializationRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo, DoctorSpecializationRepo doctorSpecializationRepo) {
        this.doctorRepo = doctorRepo;
        this.doctorSpecializationRepo = doctorSpecializationRepo;
    }
    @Override
    public List<Doctor> listAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public String deleteDoctor(Long doctorId) {
        Optional<Doctor> doctorResult = doctorRepo.findById(doctorId);

        if (doctorResult.isPresent()) {
            doctorRepo.delete(doctorResult.get());
            return "Success";
        } else {
            throw new IllegalStateException("Failed to delete. Please try again");
        }
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        Optional<Doctor> doctorResult = doctorRepo.findById(doctorId);

        Doctor doctor = null;
        if (doctorResult.isPresent()) {
            doctor = doctorResult.get();
        }

        return doctor;
    }

    @Override
    public List<DoctorSpecialization> listAllDoctorSpecialization() {
        return doctorSpecializationRepo.findAll();
    }

    @Override
    public long countAllDoctors() {
        return doctorRepo.count();
    }
}
