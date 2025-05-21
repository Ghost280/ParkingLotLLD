package com.parkinglot.impl;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.interfaces.ParkingLotFloor;

public class ParkingLotImpl implements ParkingLotFloor {

    Map<Integer, EnumMap<VehicleType, Integer>> parkingSpaces = new HashMap<>();


    @Override
    public EnumMap<VehicleType, Integer> getparkingSpaces(int floorNo) {
        return parkingSpaces.getOrDefault(floorNo, new EnumMap<>(VehicleType.class));

    }

    @Override
    public void UpdateParkingLotSpace(int floorNo, EnumMap<VehicleType, Integer> spaces) {
        if (floorNo < 0 || spaces == null) {
            throw new IllegalArgumentException("Invalid floor number or spaces map.");
        }
        parkingSpaces.put(floorNo, spaces);
        System.out.println("Updated parking spaces for floor: " + floorNo);

    }
    
}
