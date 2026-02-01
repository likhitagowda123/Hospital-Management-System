package edu.unt.hospitalmanagementsystem.entity;

import jakarta.persistence.*;

@Entity(name = "room_allocation")
public class RoomAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "billing_id")
    private Billing billing;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

