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

@WebMvcTest(ParkingSpaceController.class)
public class ParkingSpaceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.parkinglot.impl.ParkingSpaceImpl parkingSpaceImpl;

    @Test
    public void testGetAllSpaces() throws Exception {
        mockMvc.perform(get("/api/parking-spaces"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSpaces() throws Exception {
        mockMvc.perform(get("/api/parking-spaces"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateSpaces() throws Exception {
        String json = "{" +
                "\"CAR\":5," +
                "\"BIKE\":3}";
        mockMvc.perform(post("/api/parking-spaces")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.CAR", is(5)))
                .andExpect(jsonPath("$.BIKE", is(3)));
    }

    @Test
    public void testUpdateSpacesWithInvalidVehicleType() throws Exception {
        String json = "{" +
                "\"INVALID\":2}";
        mockMvc.perform(post("/api/parking-spaces")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}
