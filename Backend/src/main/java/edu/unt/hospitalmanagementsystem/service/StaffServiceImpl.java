package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.entity.Staff;
import edu.unt.hospitalmanagementsystem.entity.StaffCategory;
import edu.unt.hospitalmanagementsystem.repo.StaffCategoryRepo;
import edu.unt.hospitalmanagementsystem.repo.StaffRepo;
import edu.unt.hospitalmanagementsystem.service.interfaces.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    private StaffRepo staffRepo;
    private StaffCategoryRepo staffCategoryRepo;

    public StaffServiceImpl(StaffRepo staffRepo, StaffCategoryRepo staffCategoryRepo) {
        this.staffRepo = staffRepo;
        this.staffCategoryRepo = staffCategoryRepo;
    }

    @Override
    public List<Staff> listAllStaffs() {
        return staffRepo.findAll();
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public String deleteStaff(Long staffId) {
        Optional<Staff> staffResult = staffRepo.findById(staffId);

        if (staffResult.isPresent()) {
            staffRepo.delete(staffResult.get());
            return "Success";
        } else {
            throw new IllegalStateException("Failed to delete. Please try again");
        }
    }

    @Override
    public Staff getStaffById(Long staffId) {
        Optional<Staff> staffResult = staffRepo.findById(staffId);

        Staff staff = null;
        if (staffResult.isPresent()) {
            staff = staffResult.get();
        }

        return staff;
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public List<StaffCategory> listAllStaffCategory() {
        return staffCategoryRepo.findAll();
    }

    @Override
    public long countAllStaffs() {
        return staffRepo.count();
    }
}
