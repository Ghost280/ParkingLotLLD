package com.example.demo.model;

import java.sql.Date;

import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.interfaces.ParkingSpace;

public class Ticket {
    Date entryTime;
    Date exitTime;
    VehicleType vehicleType;

    @Autowired
    ParkingSpace parkingSpace;
    @Autowired
    Vehicle vehicles;

    public Ticket(Date entryTime, Date exitTime, VehicleType vehicleType) {
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

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public int getParkingSpace() {
       return parkingSpace.getSpaces(vehicleType);
    }
}
