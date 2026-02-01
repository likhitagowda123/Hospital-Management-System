package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.entity.Staff;
import edu.unt.hospitalmanagementsystem.entity.StaffCategory;

import java.util.List;

public interface StaffService {
    List<Staff> listAllStaffs();

    Staff updateStaff(Staff staff);

    String deleteStaff(Long staffId);

    Staff getStaffById(Long staffId);

    Staff addStaff(Staff staff);

    List<StaffCategory> listAllStaffCategory();

    long countAllStaffs();
}
