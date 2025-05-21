package com.parkinglot.interfaces;

import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.model.User;

public interface ParkingRate {
    public Long getRate(VehicleType vehicleType);
    public void setRate(VehicleType vehicleType, long rate, User user); // Set rate for a specific vehicle type
    public Long getRate(VehicleType vehicleType, int duration); // Get rate for a specific vehicle type
}
