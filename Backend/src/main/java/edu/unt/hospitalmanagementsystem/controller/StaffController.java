package edu.unt.hospitalmanagementsystem.controller;

import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.entity.Staff;
import edu.unt.hospitalmanagementsystem.entity.StaffCategory;
import edu.unt.hospitalmanagementsystem.service.interfaces.PatientService;
import edu.unt.hospitalmanagementsystem.service.interfaces.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Staff> listAllStaffs() {
        return staffService.listAllStaffs();
    }

    @ResponseBody
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Staff updateStaff(@RequestBody Staff staff) {
        if (staff == null) {
            throw new IllegalStateException("Please submit a staff to update.");
        }

        return staffService.updateStaff(staff);
    }

    @ResponseBody
    @RequestMapping(path = "/delete/{staffId}", method = RequestMethod.DELETE)
    public String deleteStaff(@PathVariable("staffId") Long staffId) {
        return staffService.deleteStaff(staffId);
    }

    @ResponseBody
    @RequestMapping("/view/{staffId}")
    public Staff getStaffById(@PathVariable("staffId") Long staffId) {
        return staffService.getStaffById(staffId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Staff addStaff(@RequestBody Staff staff) {
        if (staff == null) {
            throw new IllegalStateException("Please submit a staff to add.");
        }

        return staffService.addStaff(staff);
    }

    @ResponseBody
    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public List<StaffCategory> listAllStaffCategory() {
        return staffService.listAllStaffCategory();
    }

    @ResponseBody
    @RequestMapping(path = "/count", method = RequestMethod.GET)
    public long countAllStaffs() {
        return staffService.countAllStaffs();
    }
}
