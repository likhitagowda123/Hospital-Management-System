package edu.unt.hospitalmanagementsystem.entity;

import jakarta.persistence.*;

@Entity(name = "room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    @Column(name = "type_name")
    private String name;

    @Column(name = "cost_per_day")
    private Long costPerDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Long costPerDay) {
        this.costPerDay = costPerDay;
    }
}
