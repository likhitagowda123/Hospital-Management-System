package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import edu.unt.hospitalmanagementsystem.repo.MedicalProcedureRepo;
import edu.unt.hospitalmanagementsystem.service.interfaces.MedicalProcedureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    private MedicalProcedureRepo medicalProcedureRepo;

    public MedicalProcedureServiceImpl (MedicalProcedureRepo medicalProcedureRepo) {
        this.medicalProcedureRepo = medicalProcedureRepo;
    }

    @Override
    public List<MedicalProcedure> listAllMedicalProcedures() {
        return medicalProcedureRepo.findAll();
    }

    @Override
    public MedicalProcedure updateMedicalProcedure(MedicalProcedure medicalProcedure) {
        return medicalProcedureRepo.save(medicalProcedure);
    }

    @Override
    public String deleteMedicalProcedure(Long medicalProcedureId) {
        Optional<MedicalProcedure> medicalProcedureResult = medicalProcedureRepo.findById(medicalProcedureId);

        if (medicalProcedureResult.isPresent()) {
            medicalProcedureRepo.delete(medicalProcedureResult.get());
            return "Success";
        } else {
            throw new IllegalStateException("Failed to delete. Please try again");
        }
    }

    @Override
    public MedicalProcedure getMedicalProcedureById(Long medicalProcedureId) {
        Optional<MedicalProcedure> medicalProcedureResult = medicalProcedureRepo.findById(medicalProcedureId);

        MedicalProcedure medicalProcedure = null;
        if (medicalProcedureResult.isPresent()) {
            medicalProcedure = medicalProcedureResult.get();
        }

        return medicalProcedure;
    }

    @Override
    public MedicalProcedure addMedicalProcedure(MedicalProcedure medicalProcedure) {
        return medicalProcedureRepo.save(medicalProcedure);
    }
}
