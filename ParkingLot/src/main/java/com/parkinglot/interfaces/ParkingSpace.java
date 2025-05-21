package com.parkinglot.interfaces;

import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.model.User;

public interface ParkingSpace {
   public int getSpaces(VehicleType vehicleType);
   public void updateSpaces(VehicleType vehicleType, int count, User user);

}
