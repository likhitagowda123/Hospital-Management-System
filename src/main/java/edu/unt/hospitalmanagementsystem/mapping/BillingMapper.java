package edu.unt.hospitalmanagementsystem.mapping;

import edu.unt.hospitalmanagementsystem.dto.BillingDTO;
import edu.unt.hospitalmanagementsystem.dto.RoomAllocationDTO;
import edu.unt.hospitalmanagementsystem.dto.TreatmentDTO;
import edu.unt.hospitalmanagementsystem.entity.Billing;
import edu.unt.hospitalmanagementsystem.entity.RoomAllocation;
import edu.unt.hospitalmanagementsystem.entity.Treatment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillingMapper {

    public BillingDTO mapBillingDetails(Billing billing, List<Treatment> treatmentList, List<RoomAllocation> roomAllocationList) {

        BillingDTO billingDTO = new BillingDTO();

        billingDTO.setId(billing.getId());
        billingDTO.setCreatedDate(billing.getCreatedDate());
        billingDTO.setTotalCost(billing.getTotalCost());
        billingDTO.setPatient(billing.getPatient());
        billingDTO.setStatus(billing.getStatus());

        List<TreatmentDTO> treatmentDTOs = treatmentList.stream()
                .map(treatment -> {
                    TreatmentDTO treatmentDTO = new TreatmentDTO();
                    treatmentDTO.setId(treatment.getId());
                    treatmentDTO.setProcedure(treatment.getProcedure()); // Assuming MedicalProcedure is a simple DTO
                    return treatmentDTO;
                })
                .toList();

        billingDTO.setTreatments(treatmentDTOs);

        List<RoomAllocationDTO> roomAllocationDTOS = roomAllocationList.stream()
                .map(roomAllocation -> {
                    RoomAllocationDTO roomAllocationDTO = new RoomAllocationDTO();
                    roomAllocationDTO.setId(roomAllocation.getId());
                    roomAllocationDTO.setRoom(roomAllocation.getRoom());
                    return roomAllocationDTO;
                })
                .toList();

        billingDTO.setRoomAllocations(roomAllocationDTOS);

        return billingDTO;
    }
}
