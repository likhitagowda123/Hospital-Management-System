package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.StaffCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffCategoryRepo  extends JpaRepository<StaffCategory, Long> {
}
