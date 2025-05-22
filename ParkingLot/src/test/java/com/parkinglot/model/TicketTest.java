package com.parkinglot.model;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.parkinglot.enums.VehicleType.VehicleType;

public class TicketTest {
    @Test
    public void testTicketConstructorAndGetters() {
        Date entry = Date.valueOf("2025-05-22");
        Date exit = Date.valueOf("2025-05-23");
        VehicleType type = VehicleType.CAR;
        Ticket ticket = new Ticket(entry, exit, type);
        assertEquals(entry, ticket.getEntryTime());
        assertEquals(exit, ticket.getExitTime());
        assertEquals(type, ticket.getVehicleType());
    }

    @Test
    public void testNullValues() {
        Ticket ticket = new Ticket(null, null, null);
        assertNull(ticket.getEntryTime());
        assertNull(ticket.getExitTime());
        assertNull(ticket.getVehicleType());
    }
}
