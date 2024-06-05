package com.cuong.springbootdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vehicle_id", nullable = false)
    private String vehicle_id;

    @Column(name = "vehicle_name", nullable = false)
    private String vehicle_name;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicle_model;

    @Column(name = "year_of_manufacture", nullable = false)
    private long year_of_manufacture;

    @Column(name = "vehicle_color" )
    private String vehicle_color;

    public Vehicle(String vehicle_id, String vehicle_name, String vehicle_model, long year_of_manufacture, String vehicle_color) {
        this.vehicle_id = vehicle_id;
        this.vehicle_name = vehicle_name;
        this.vehicle_model = vehicle_model;
        this.year_of_manufacture = year_of_manufacture;
        this.vehicle_color = vehicle_color;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }


    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public long getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(long year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }
}
