package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.RoomAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomAllocationRepo extends JpaRepository<RoomAllocation, Long> {
    List<RoomAllocation> getRoomAllocationByBillingId(Long id);

}
