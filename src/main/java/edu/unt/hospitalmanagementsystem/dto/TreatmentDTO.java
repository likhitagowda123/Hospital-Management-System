package edu.unt.hospitalmanagementsystem.dto;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import edu.unt.hospitalmanagementsystem.entity.Treatment;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public class TreatmentDTO {

    private Long id;
    private MedicalProcedure procedure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProcedure(MedicalProcedure procedure) {
        this.procedure = procedure;
    }

    public MedicalProcedure getProcedure() {
        return procedure;
    }
}
