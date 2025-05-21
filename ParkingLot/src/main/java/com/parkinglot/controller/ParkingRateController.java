package com.parkinglot.controller;

import com.parkinglot.enums.VehicleType.VehicleType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/parking-rates")
public class ParkingRateController {
    private final Map<VehicleType, Long> rates = new EnumMap<>(VehicleType.class);

    @GetMapping
    public ResponseEntity<Map<VehicleType, Long>> getRates() {
        return ResponseEntity.ok(rates);
    }

    @PostMapping
    public ResponseEntity<Map<VehicleType, Long>> updateRates(@RequestBody Map<String, Long> updates) {
        for (Map.Entry<String, Long> entry : updates.entrySet()) {
            VehicleType type = VehicleType.valueOf(entry.getKey());
            rates.put(type, entry.getValue());
        }
        return ResponseEntity.ok(rates);
    }
}
