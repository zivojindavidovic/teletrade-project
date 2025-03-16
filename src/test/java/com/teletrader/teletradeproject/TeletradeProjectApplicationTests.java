package com.teletrader.teletradeproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teletrader.teletradeproject.controllers.v1.order.request.OrderSaveDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TeletradeProjectApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenFieldsAreMissing_thenShouldReturnBadRequest() throws Exception {

        OrderSaveDTO request = new OrderSaveDTO();

        mockMvc.perform(
                        post("/api/v1/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenAllFieldsValid_thenShouldReturnCreated() throws Exception {
        OrderSaveDTO request = new OrderSaveDTO();
        request.setUserId(1L);
        request.setStockId(1L);
        request.setPrice(10.5);
        request.setQuantity(10);
        request.setType("BUY");

        mockMvc.perform(
                        post("/api/v1/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(status().isCreated());
    }

}
