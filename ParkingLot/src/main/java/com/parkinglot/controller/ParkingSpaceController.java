package com.parkinglot.controller;

import com.parkinglot.enums.VehicleType.VehicleType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/parking-spaces")
public class ParkingSpaceController {
    private final Map<VehicleType, Integer> spaces = new EnumMap<>(VehicleType.class);

    @GetMapping
    public ResponseEntity<Map<VehicleType, Integer>> getSpaces() {
        return ResponseEntity.ok(spaces);
    }

    @PostMapping
    public ResponseEntity<Map<VehicleType, Integer>> updateSpaces(@RequestBody Map<String, Integer> updates) {
        for (Map.Entry<String, Integer> entry : updates.entrySet()) {
            VehicleType type = VehicleType.valueOf(entry.getKey());
            spaces.put(type, spaces.getOrDefault(type, 0) + entry.getValue());
        }
        return ResponseEntity.ok(spaces);
    }
}
