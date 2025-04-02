package com.parkinglot.impl;

import java.util.EnumMap;

import com.example.demo.model.User;
import com.parkinglot.enums.VehicleType.UserType;
import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.interfaces.ParkingRate;

public class ParkingRateImpl implements ParkingRate{

    private EnumMap<VehicleType, Long> rates = new EnumMap<>(VehicleType.class);


    public ParkingRateImpl(long bikeRate, long carRate, long truckRate) {
        for (VehicleType type : VehicleType.values()) {
            rates.put(type, 0L);
        }

    }

    public Long getRate(VehicleType vehicleType) {
        return rates.getOrDefault(vehicleType, 0L);
    }

    public void setRate(VehicleType vehicleType, long rate, User user) {
        if (user.getUserType() == UserType.ADMIN) {
            rates.put(vehicleType, rate);
        } else {
            System.out.println("You are not authorized to set rates.");
        }
    }

    @Override
    public Long getRate(VehicleType vehicleType, int duration) {
        Long rate = rates.get(vehicleType);
        if (rate != null) {
            return rate * duration; // Assuming rate is per hour, multiply by duration
        } else {
            System.out.println("Rate not set for vehicle type: " + vehicleType);
            return 0L;
        }
    }

    
}
