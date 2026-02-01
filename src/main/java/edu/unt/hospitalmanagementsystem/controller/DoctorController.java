package edu.unt.hospitalmanagementsystem.controller;

import edu.unt.hospitalmanagementsystem.entity.Doctor;
import edu.unt.hospitalmanagementsystem.entity.DoctorSpecialization;
import edu.unt.hospitalmanagementsystem.entity.StaffCategory;
import edu.unt.hospitalmanagementsystem.service.interfaces.DoctorService;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Doctor> listAllDoctors() {
        return doctorService.listAllDoctors();
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        if (doctor == null) {
            throw new IllegalStateException("Please submit a doctor to add.");
        }

        return doctorService.addDoctor(doctor);
    }

    @ResponseBody
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        if (doctor == null) {
            throw new IllegalStateException("Please submit a doctor to update.");
        }

        return doctorService.updateDoctor(doctor);
    }

    @ResponseBody
    @RequestMapping(path = "/delete/{doctorId}", method = RequestMethod.DELETE)
    public String deleteDoctor(@PathVariable("doctorId") Long doctorId) {
        return doctorService.deleteDoctor(doctorId);
    }

    @ResponseBody
    @RequestMapping("/view/{doctorId}")
    public Doctor getDoctorById(@PathVariable("doctorId") Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @ResponseBody
    @RequestMapping(path = "/specialization", method = RequestMethod.GET)
    public List<DoctorSpecialization> listAllDoctorSpecialization() {
        return doctorService.listAllDoctorSpecialization();
    }

    @ResponseBody
    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public long countAllDoctors() {
        return doctorService.countAllDoctors();
    }
}
