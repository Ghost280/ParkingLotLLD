package com.example.demo.model;

import com.parkinglot.enums.VehicleType.VehicleType;

public class Vehicle {
    private String licensePlate; // Unique identifier for the vehicle
    private VehicleType vehicleType; // Enum for vehicle type (e.g., BIKE, CAR, TRUCK)
    private String ownerName; // Optional: Owner's name or identifier

    public Vehicle(String licensePlate, VehicleType vehicleType, String ownerName) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // Setters (optional, based on design requirements)
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}