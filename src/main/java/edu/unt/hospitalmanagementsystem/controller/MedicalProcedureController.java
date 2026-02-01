package edu.unt.hospitalmanagementsystem.controller;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.service.interfaces.MedicalProcedureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-procedure")
public class MedicalProcedureController {

    private MedicalProcedureService medicalProcedureService;

    public MedicalProcedureController(MedicalProcedureService medicalProcedureService) {
        this.medicalProcedureService = medicalProcedureService;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<MedicalProcedure> listAllMedicalProcedures() {
        return medicalProcedureService.listAllMedicalProcedures();
    }

    @ResponseBody
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public MedicalProcedure updateMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure) {
        if (medicalProcedure == null) {
            throw new IllegalStateException("Please submit a Medical Procedure to update.");
        }

        return medicalProcedureService.updateMedicalProcedure(medicalProcedure);
    }

    @ResponseBody
    @RequestMapping(path = "/delete/{medicalProcedureId}", method = RequestMethod.DELETE)
    public String deleteMedicalProcedure(@PathVariable("medicalProcedureId") Long medicalProcedureId) {
        return medicalProcedureService.deleteMedicalProcedure(medicalProcedureId);
    }

    @ResponseBody
    @RequestMapping("/view/{medicalProcedureId}")
    public MedicalProcedure getMedicalProcedureById(@PathVariable("medicalProcedureId") Long medicalProcedureId) {
        return medicalProcedureService.getMedicalProcedureById(medicalProcedureId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public MedicalProcedure addMedicalProcedure(@RequestBody MedicalProcedure medicalProcedure) {
        if (medicalProcedure == null) {
            throw new IllegalStateException("Please submit a medical procedure to add.");
        }

        return medicalProcedureService.addMedicalProcedure(medicalProcedure);
    }
}
