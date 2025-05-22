package com.parkinglot.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.parkinglot.enums.VehicleType.UserType;
import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.model.User;

public class ParkingRateImplTest {
    @Test
    public void testSetAndGetRateAsAdmin() {
        ParkingRateImpl rateImpl = new ParkingRateImpl(10, 20, 30);
        User admin = new User("admin", "admin@email.com", UserType.ADMIN);
        rateImpl.setRate(VehicleType.CAR, 50, admin);
        assertEquals(50, rateImpl.getRate(VehicleType.CAR));
    }

    @Test
    public void testSetRateAsNonAdmin() {
        ParkingRateImpl rateImpl = new ParkingRateImpl(10, 20, 30);
        User user = new User("user", "user@email.com", UserType.REGULAR_USER);
        rateImpl.setRate(VehicleType.BIKE, 15, user);
        assertEquals(0, rateImpl.getRate(VehicleType.BIKE));
    }

    @Test
    public void testGetRateWithDuration() {
        ParkingRateImpl rateImpl = new ParkingRateImpl(10, 20, 30);
        User admin = new User("admin", "admin@email.com", UserType.ADMIN);
        rateImpl.setRate(VehicleType.TRUCK, 100, admin);
        assertEquals(300, rateImpl.getRate(VehicleType.TRUCK, 3));
    }
}
