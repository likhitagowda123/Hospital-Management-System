package edu.unt.hospitalmanagementsystem.dto;

import edu.unt.hospitalmanagementsystem.entity.MedicalProcedure;
import edu.unt.hospitalmanagementsystem.entity.Room;

public class RoomAllocationDTO {

    private Long id;
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
