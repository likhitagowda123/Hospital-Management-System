package edu.unt.hospitalmanagementsystem.entity;

import jakarta.persistence.*;

@Entity(name = "treatment")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "billing_id")
    private Billing billing;

    @OneToOne
    @JoinColumn(name = "procedure_id")
    private MedicalProcedure procedure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public MedicalProcedure getProcedure() {
        return procedure;
    }

    public void setProcedure(MedicalProcedure procedure) {
        this.procedure = procedure;
    }
}
