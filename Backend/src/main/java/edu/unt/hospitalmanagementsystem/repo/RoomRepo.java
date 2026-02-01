package edu.unt.hospitalmanagementsystem.repo;

import edu.unt.hospitalmanagementsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM room r WHERE r.patient IS NULL")
    List<Room> findByPatientIdIsNull();
}
