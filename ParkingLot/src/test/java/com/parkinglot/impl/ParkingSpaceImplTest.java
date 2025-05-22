package com.parkinglot.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.parkinglot.enums.VehicleType.UserType;
import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.model.User;

public class ParkingSpaceImplTest {
    @Test
    public void testUpdateAndGetSpacesAsAdmin() {
        ParkingSpaceImpl impl = new ParkingSpaceImpl();
        User admin = new User("admin", "admin@email.com", UserType.ADMIN);
        impl.updateSpaces(VehicleType.CAR, 5, admin);
        assertEquals(5, impl.getSpaces(VehicleType.CAR));
    }

    @Test
    public void testUpdateSpacesAsNonAdmin() {
        ParkingSpaceImpl impl = new ParkingSpaceImpl();
        User user = new User("user", "user@email.com", UserType.REGULAR_USER);
        impl.updateSpaces(VehicleType.BIKE, 3, user);
        assertEquals(0, impl.getSpaces(VehicleType.BIKE));
    }
}
