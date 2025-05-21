package com.parkinglot.impl;


import java.util.EnumMap;

import com.parkinglot.enums.VehicleType.UserType;
import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.interfaces.ParkingSpace;
import com.parkinglot.model.User;

public class ParkingSpaceImpl implements ParkingSpace {
    private EnumMap<VehicleType, Integer> spaces = new EnumMap<>(VehicleType.class);

    public ParkingSpaceImpl() {
        for (VehicleType type : VehicleType.values()) {
            spaces.put(type, 0);
        }
    }

    public int getSpaces(VehicleType vehicleType) {
        return spaces.getOrDefault(vehicleType, 0);
    }

    public void updateSpaces(VehicleType vehicleType, int count, User user) {
        if (user.getUserType() == UserType.ADMIN) {
            spaces.put(vehicleType, spaces.getOrDefault(vehicleType, 0) + count);
        } else {
            System.out.println("You are not authorized to modify spaces.");
        }
    }
}