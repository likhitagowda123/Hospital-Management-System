package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.entity.Room;
import edu.unt.hospitalmanagementsystem.repo.RoomRepo;
import edu.unt.hospitalmanagementsystem.service.interfaces.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepo roomRepo;

    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }
    @Override
    public List<Room> listAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public List<Room> listAllAvailableRooms() {
        return roomRepo.findByPatientIdIsNull();
    }
}
