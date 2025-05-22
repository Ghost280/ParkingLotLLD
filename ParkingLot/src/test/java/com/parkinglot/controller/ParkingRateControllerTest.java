package com.parkinglot.controller;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ParkingRateController.class)
public class ParkingRateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.parkinglot.impl.ParkingRateImpl parkingRateImpl;

    @Test
    public void testGetAllRates() throws Exception {
        mockMvc.perform(get("/api/parking-rates"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateRates() throws Exception {
        String json = "{" +
                "\"CAR\":100," +
                "\"BIKE\":50}";
        mockMvc.perform(post("/api/parking-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.CAR", is(100)))
                .andExpect(jsonPath("$.BIKE", is(50)));
    }

    @Test
    public void testUpdateRatesWithInvalidVehicleType() throws Exception {
        String json = "{" +
                "\"INVALID\":200}";
        mockMvc.perform(post("/api/parking-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUpdateRatesWithEmptyBody() throws Exception {
        String json = "{}";
        mockMvc.perform(post("/api/parking-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetRatesAfterUpdate() throws Exception {
        String json = "{" +
                "\"CAR\":150," +
                "\"BIKE\":75}";
        mockMvc.perform(post("/api/parking-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/parking-rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.CAR", is(150)))
                .andExpect(jsonPath("$.BIKE", is(75)));
    }
}
