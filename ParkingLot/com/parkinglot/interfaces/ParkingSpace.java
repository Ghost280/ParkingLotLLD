package com.parkinglot.interfaces;

import com.example.demo.model.User;
import com.parkinglot.enums.VehicleType.VehicleType;

public interface ParkingSpace {
   public int getSpaces(VehicleType vehicleType);
   public void updateSpaces(VehicleType vehicleType, int count, User user);

}
