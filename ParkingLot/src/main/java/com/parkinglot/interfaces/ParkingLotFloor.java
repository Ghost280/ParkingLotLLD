package com.parkinglot.interfaces;

import java.util.EnumMap;

import com.parkinglot.enums.VehicleType.VehicleType;

public interface ParkingLotFloor {

    public EnumMap<VehicleType, Integer> getparkingSpaces(int floorNo);
    public void UpdateParkingLotSpace(int floorNo, EnumMap<VehicleType, Integer> spaces);
}