package com.parkinglot.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.enums.VehicleType.VehicleType;
import com.parkinglot.model.Ticket;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final List<Ticket> tickets = new ArrayList<>();

    @PostMapping("/entry")
    public ResponseEntity<Ticket> createEntryTicket(@RequestBody Map<String, Object> payload) {
        // expects entryTime (yyyy-MM-dd), vehicleType
        Date entryTime = Date.valueOf((String) payload.get("entryTime"));
        VehicleType vehicleType = VehicleType.valueOf((String) payload.get("vehicleType"));
        Ticket ticket = new Ticket(entryTime, null, vehicleType);
        tickets.add(ticket);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/exit")
    public ResponseEntity<Ticket> markExit(@RequestBody Map<String, Object> payload) {
        // expects entryTime (yyyy-MM-dd), exitTime (yyyy-MM-dd), vehicleType
        Date entryTime = Date.valueOf((String) payload.get("entryTime"));
        Date exitTime = Date.valueOf((String) payload.get("exitTime"));
        VehicleType vehicleType = VehicleType.valueOf((String) payload.get("vehicleType"));
        for (Ticket t : tickets) {
            if (t.getEntryTime().equals(entryTime) && t.getVehicleType() == vehicleType) {
                // Set exitTime on the ticket
                try {
                    java.lang.reflect.Field exitField = Ticket.class.getDeclaredField("exitTime");
                    exitField.setAccessible(true);
                    exitField.set(t, exitTime);
                } catch (Exception e) {
                    // ignore
                }
                return ResponseEntity.ok(t);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(tickets);
    }
}
