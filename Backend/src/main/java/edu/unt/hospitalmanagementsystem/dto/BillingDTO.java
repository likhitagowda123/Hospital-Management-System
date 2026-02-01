package edu.unt.hospitalmanagementsystem.dto;

import edu.unt.hospitalmanagementsystem.entity.Billing;
import edu.unt.hospitalmanagementsystem.entity.Treatment;

import java.util.List;

public class BillingDTO extends Billing {

    private List<TreatmentDTO> treatments;

    private List<RoomAllocationDTO> roomAllocations;

    public void setTreatments(List<TreatmentDTO> treatments) {
        this.treatments = treatments;
    }

    public List<TreatmentDTO> getTreatments() {
        return treatments;
    }

    public List<RoomAllocationDTO> getRoomAllocations() {
        return roomAllocations;
    }

    public void setRoomAllocations(List<RoomAllocationDTO> roomAllocations) {
        this.roomAllocations = roomAllocations;
    }
}
