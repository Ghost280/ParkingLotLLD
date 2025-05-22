package com.parkinglot.impl;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.parkinglot.enums.VehicleType.VehicleType;

public class ParkingLotImplTest {
    @Test
    public void testUpdateAndGetParkingSpaces() {
        ParkingLotImpl lot = new ParkingLotImpl();
        EnumMap<VehicleType, Integer> spaces = new EnumMap<>(VehicleType.class);
        spaces.put(VehicleType.CAR, 10);
        lot.UpdateParkingLotSpace(1, spaces);
        assertEquals(10, lot.getparkingSpaces(1).get(VehicleType.CAR));
    }

    @Test
    public void testUpdateParkingLotSpaceInvalid() {
        ParkingLotImpl lot = new ParkingLotImpl();
        assertThrows(IllegalArgumentException.class, () -> lot.UpdateParkingLotSpace(-1, null));
    }
}
