package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> listAllRooms();

    List<Room> listAllAvailableRooms();
}
