package edu.unt.hospitalmanagementsystem.controller;

import edu.unt.hospitalmanagementsystem.entity.Room;
import edu.unt.hospitalmanagementsystem.entity.Staff;
import edu.unt.hospitalmanagementsystem.service.interfaces.RoomService;
import edu.unt.hospitalmanagementsystem.service.interfaces.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @ResponseBody
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<Room> listAllRooms() {
        return roomService.listAllRooms();
    }

    @ResponseBody
    @RequestMapping(path = "/available", method = RequestMethod.GET)
    public List<Room> listAllAvailableRooms() {
        return roomService.listAllAvailableRooms();
    }
}
