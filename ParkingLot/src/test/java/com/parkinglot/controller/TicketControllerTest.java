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

@WebMvcTest(TicketController.class)
public class TicketControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private com.parkinglot.impl.ParkingLotImpl parkingLotImpl;

    @Test
    public void testGetAllTickets() throws Exception {
        mockMvc.perform(get("/api/tickets"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateEntryTicket() throws Exception {
        String json = "{" +
                "\"entryTime\":\"2025-05-22\"," +
                "\"vehicleType\":\"CAR\"}";
        mockMvc.perform(post("/api/tickets/entry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.entryTime", is("2025-05-22")))
                .andExpect(jsonPath("$.vehicleType", is("CAR")));
    }

    @Test
    public void testCreateEntryTicketWithInvalidVehicleType() throws Exception {
        String json = "{" +
                "\"entryTime\":\"2025-05-22\"," +
                "\"vehicleType\":\"INVALID\"}";
        mockMvc.perform(post("/api/tickets/entry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testMarkExit() throws Exception {
        // First create entry
        String entryJson = "{" +
                "\"entryTime\":\"2025-05-22\"," +
                "\"vehicleType\":\"CAR\"}";
        mockMvc.perform(post("/api/tickets/entry")
                .contentType(MediaType.APPLICATION_JSON)
                .content(entryJson))
                .andExpect(status().isOk());
        // Now mark exit
        String exitJson = "{" +
                "\"entryTime\":\"2025-05-22\"," +
                "\"exitTime\":\"2025-05-23\"," +
                "\"vehicleType\":\"CAR\"}";
        mockMvc.perform(post("/api/tickets/exit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(exitJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.exitTime", is("2025-05-23")));
    }

    @Test
    public void testMarkExitWithNoMatchingTicket() throws Exception {
        String exitJson = "{" +
                "\"entryTime\":\"2025-05-21\"," +
                "\"exitTime\":\"2025-05-23\"," +
                "\"vehicleType\":\"CAR\"}";
        mockMvc.perform(post("/api/tickets/exit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(exitJson))
                .andExpect(status().is4xxClientError());
    }
}
