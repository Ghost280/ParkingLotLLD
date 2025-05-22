package com.parkinglot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.parkinglot.impl.ParkingLotImpl parkingLotImpl;

    @Test
    public void testGetAllVehicles() throws Exception {
        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk());
    }
}
