package com.parkinglot.model;

import java.sql.Date;

public class Ticket {
    Date entryTime;
    Date exitTime;
    com.parkinglot.enums.VehicleType.VehicleType vehicleType;

    public Ticket(Date entryTime, Date exitTime, com.parkinglot.enums.VehicleType.VehicleType vehicleType) {
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.vehicleType = vehicleType;
    }

    public Date getEntryTime() {
        return this.entryTime;
    }

    public Date getExitTime() {
        return this.exitTime;
    }

    public com.parkinglot.enums.VehicleType.VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
