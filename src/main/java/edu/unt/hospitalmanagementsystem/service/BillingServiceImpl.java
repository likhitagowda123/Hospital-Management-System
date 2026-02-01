package edu.unt.hospitalmanagementsystem.service;

import edu.unt.hospitalmanagementsystem.dto.BillingDTO;
import edu.unt.hospitalmanagementsystem.dto.RoomAllocationDTO;
import edu.unt.hospitalmanagementsystem.dto.TreatmentDTO;
import edu.unt.hospitalmanagementsystem.entity.*;
import edu.unt.hospitalmanagementsystem.mapping.BillingMapper;
import edu.unt.hospitalmanagementsystem.repo.*;
import edu.unt.hospitalmanagementsystem.service.interfaces.BillingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    private BillingRepo billingRepo;
    private TreatmentRepo treatmentRepo;
    private RoomRepo roomRepo;
    private RoomAllocationRepo roomAllocationRepo;
    private MedicalProcedureRepo medicalProcedureRepo;

    private BillingMapper billingMapper;

    public BillingServiceImpl (BillingRepo billingRepo, TreatmentRepo treatmentRepo, RoomRepo roomRepo, RoomAllocationRepo roomAllocationRepo, MedicalProcedureRepo medicalProcedureRepo,  BillingMapper billingMapper) {
        this.billingRepo = billingRepo;
        this.treatmentRepo = treatmentRepo;
        this.roomRepo = roomRepo;
        this.roomAllocationRepo = roomAllocationRepo;
        this.medicalProcedureRepo = medicalProcedureRepo;
        this.billingMapper = billingMapper;
    }
    @Override
    public List<BillingDTO> getBillingByPatientId(Long patientId) {
        List<Billing> billingList = billingRepo.getBillingByPatientId(patientId);

        List<BillingDTO> billingDTOList = new ArrayList<>();

        for (Billing billing: billingList) {
            List<Treatment> treatmentList = treatmentRepo.getTreatmentsByBillingId(billing.getId());
            List<RoomAllocation> roomAllocationList = roomAllocationRepo.getRoomAllocationByBillingId(billing.getId());

            BillingDTO billingDTO = billingMapper.mapBillingDetails(billing, treatmentList, roomAllocationList);
            billingDTOList.add(billingDTO);
        }

        return billingDTOList;
    }

    @Override
    public List<BillingDTO> listAllBillings() {
        List<Billing> billingList = billingRepo.findAll();

        List<BillingDTO> billingDTOList = new ArrayList<>();

        for (Billing billing: billingList) {
            List<Treatment> treatmentList = treatmentRepo.getTreatmentsByBillingId(billing.getId());
            List<RoomAllocation> roomAllocationList = roomAllocationRepo.getRoomAllocationByBillingId(billing.getId());

            BillingDTO billingDTO = billingMapper.mapBillingDetails(billing, treatmentList, roomAllocationList);
            billingDTOList.add(billingDTO);
        }

        return billingDTOList;
    }

    @Override
    public BillingDTO getBillingById(Long billingId) {
        Optional<Billing> billingResult = billingRepo.findById(billingId);

        Billing billing = null;
        if (billingResult.isPresent()) {
            billing = billingResult.get();
            List<Treatment> treatmentList = treatmentRepo.getTreatmentsByBillingId(billing.getId());
            List<RoomAllocation> roomAllocationList = roomAllocationRepo.getRoomAllocationByBillingId(billing.getId());

            return billingMapper.mapBillingDetails(billing, treatmentList, roomAllocationList);

        } else {
            throw new IllegalStateException("Failed to get billing details. Please try again");
        }
    }

    @Override
    public Billing billPatient(BillingDTO billingDTO) {
        Billing billing = new Billing();
        billing.setCreatedDate(billingDTO.getCreatedDate());
        billing.setPatient(billingDTO.getPatient());
        billing.setStatus(billingDTO.getStatus());

        int totalCost = 0;
        billing.setTotalCost((long) totalCost);
        billing = billingRepo.save(billing);

        for (TreatmentDTO treatmentDTO: billingDTO.getTreatments()) {
            Treatment treatment = new Treatment();
            treatment.setBilling(billing);
            treatment.setProcedure(treatmentDTO.getProcedure());
            treatmentRepo.save(treatment);

            Optional<MedicalProcedure> medicalProcedureResult = medicalProcedureRepo.findById(treatmentDTO.getProcedure().getId());
            if (medicalProcedureResult.isPresent()) {
                MedicalProcedure medicalProcedure = medicalProcedureResult.get();

                totalCost += medicalProcedure.getCost();
            }
        }

        for (RoomAllocationDTO roomAllocationDTO: billingDTO.getRoomAllocations()) {
            if (roomAllocationDTO.getRoom().getId() != null) {
                RoomAllocation roomAllocation = new RoomAllocation();
                roomAllocation.setBilling(billing);
                roomAllocation.setRoom(roomAllocationDTO.getRoom());
                roomAllocationRepo.save(roomAllocation);

                Optional<Room> roomResult = roomRepo.findById(roomAllocationDTO.getRoom().getId());

                Room room = null;
                if (roomResult.isPresent()) {
                    room = roomResult.get();
                    room.setPatient(billingDTO.getPatient());
                    roomRepo.save(room);

                    totalCost += room.getType().getCostPerDay();
                } else {
                    throw new IllegalStateException("Failed to create the bill. Please try again");
                }
            }
        }

        billing.setTotalCost((long) totalCost);
        billing = billingRepo.save(billing);

        return billing;
    }

    @Override
    public String deleteBilling(Long billingId) {
        Optional<Billing> billingResult = billingRepo.findById(billingId);

        if (billingResult.isPresent()) {
            Billing billing = billingResult.get();
            if (billing.getStatus().getName().equals("Unpaid")) {
                List<RoomAllocation> roomAllocationList = roomAllocationRepo.getRoomAllocationByBillingId(billingId);
                for (RoomAllocation roomAllocation: roomAllocationList){
                    Long roomAllocationId = roomAllocation.getId();
                    Long roomId = roomAllocation.getRoom().getId();
                    Optional<Room> roomResult = roomRepo.findById(roomId);
                    if (roomResult.isPresent()) {
                        Room room = roomResult.get();
                        room.setPatient(null);
                        roomRepo.save(room);
                    }
                    roomAllocationRepo.deleteById(roomAllocationId);
                }
                List<Treatment> treatmentList = treatmentRepo.getTreatmentsByBillingId(billingId);
                for (Treatment treatment: treatmentList){
                    Long treatmentId = treatment.getId();
                    treatmentRepo.deleteById(treatmentId);
                }
                billingRepo.delete(billingResult.get());
                return "Success";
            } else {
                return "Cannot delete Paid bills!";
            }
        } else {
            return "Failed to delete. Please try again";
        }
    }

    @Override
    public Billing payBill(Long billingId) {
        Optional<Billing> billingResult = billingRepo.findById(billingId);

        Billing billing = null;
        if (billingResult.isPresent()) {
            billing = billingResult.get();

            // Deallocate the rooms
            List<RoomAllocation> roomAllocationList = roomAllocationRepo.getRoomAllocationByBillingId(billingId);
            for (RoomAllocation roomAllocation: roomAllocationList) {
                Long roomId = roomAllocation.getRoom().getId();

                Optional<Room> roomResult = roomRepo.findById(roomId);

                if (roomResult.isPresent()) {
                    Room room = roomResult.get();
                    room.setPatient(null);

                    roomRepo.save(room);
                }
            }

            // Marking the status as paid
            BillingStatus billingStatus = new BillingStatus();
            billingStatus.setId(1L);
            billingStatus.setName("Paid");
            billing.setStatus(billingStatus);

            billing = billingRepo.save(billing);
        }

        return billing;
    }
}
