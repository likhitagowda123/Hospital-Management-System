package edu.unt.hospitalmanagementsystem.controller;

import edu.unt.hospitalmanagementsystem.dto.BillingDTO;
import edu.unt.hospitalmanagementsystem.entity.Billing;
import edu.unt.hospitalmanagementsystem.entity.Doctor;
import edu.unt.hospitalmanagementsystem.entity.Patient;
import edu.unt.hospitalmanagementsystem.service.interfaces.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private BillingService billingService;

    public BillingController (BillingService billingService) {
        this.billingService = billingService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<BillingDTO> listAllBillings() {
        return billingService.listAllBillings();
    }

    @ResponseBody
    @RequestMapping("/patient/{patientId}")
    public List<BillingDTO> getBillingByPatientId(@PathVariable("patientId") Long patientId) {
        return billingService.getBillingByPatientId(patientId);
    }

    @ResponseBody
    @RequestMapping("/view/{billingId}")
    public BillingDTO getBillingById(@PathVariable("billingId") Long billingId) {
        return billingService.getBillingById(billingId);
    }

    @ResponseBody
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public Billing billPatient(@RequestBody BillingDTO billingDTO) {
        return billingService.billPatient(billingDTO);
    }

    @ResponseBody
    @RequestMapping(path = "/delete/{billingId}", method = RequestMethod.DELETE)
    public String deleteBilling(@PathVariable("billingId") Long billingId) {
        return billingService.deleteBilling(billingId);
    }

    @ResponseBody
    @RequestMapping(path = "/pay/{billingId}", method = RequestMethod.PUT)
    public Billing payBill(@PathVariable("billingId") Long billingId) {
        return billingService.payBill(billingId);
    }
}
