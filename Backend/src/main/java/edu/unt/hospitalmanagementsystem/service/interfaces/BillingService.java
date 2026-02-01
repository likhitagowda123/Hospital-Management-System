package edu.unt.hospitalmanagementsystem.service.interfaces;

import edu.unt.hospitalmanagementsystem.dto.BillingDTO;
import edu.unt.hospitalmanagementsystem.entity.Billing;

import java.util.List;

public interface BillingService {
    List<BillingDTO> getBillingByPatientId(Long patientId);

    List<BillingDTO> listAllBillings();

    BillingDTO getBillingById(Long billingId);

    Billing payBill(Long billingId);

    Billing billPatient(BillingDTO billingDTO);

    String deleteBilling(Long billingId);
}
