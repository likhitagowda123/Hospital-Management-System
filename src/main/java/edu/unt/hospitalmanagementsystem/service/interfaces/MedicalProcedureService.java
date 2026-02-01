package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import edu.unt.hospitalmanagementsystem.entity.Staff;

import java.util.List;

public interface MedicalProcedureService {
    List<MedicalProcedure> listAllMedicalProcedures();

    MedicalProcedure updateMedicalProcedure(MedicalProcedure medicalProcedure);

    String deleteMedicalProcedure(Long medicalProcedureId);

    MedicalProcedure getMedicalProcedureById(Long medicalProcedureId);

    MedicalProcedure addMedicalProcedure(MedicalProcedure medicalProcedure);
}
