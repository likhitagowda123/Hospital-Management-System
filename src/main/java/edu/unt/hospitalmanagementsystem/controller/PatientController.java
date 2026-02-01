package edu.unt.hospitalmanagementsystem.controller;


import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.service.interfaces.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Patient> listAllPatients() {
        return patientService.listAllPatients();
    }

    @ResponseBody
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Patient updatePatient(@RequestBody Patient patient) {
        if (patient == null) {
            throw new IllegalStateException("Please submit a patient to update.");
        }

        return patientService.updatePatient(patient);
    }

    @ResponseBody
    @RequestMapping(path = "/delete/{patientId}", method = RequestMethod.DELETE)
    public String deletePatient(@PathVariable("patientId") Long patientId) {
        return patientService.deletePatient(patientId);
    }

    @ResponseBody
    @RequestMapping("/view/{patientId}")
    public Patient getPatientById(@PathVariable("patientId") Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Patient addPatient(@RequestBody Patient patient) {
        if (patient == null) {
            throw new IllegalStateException("Please submit a patient to add.");
        }

        return patientService.addPatient(patient);
    }
}
