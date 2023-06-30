package com.exercise.ApiPrices.controller;

import com.exercise.ApiPrices.model.dto.ProductPriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProductControllerGetProductPriceStatus200() throws Exception {

        final String brandId_param = "1";
        final String productId_param = "35455";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        final String date_param = LocalDateTime.parse("2020-06-14T10:00:00").format(formatter);

        ProductPriceDTO expectedDTO = ProductPriceDTO.builder()
                .productId(35455)
                .brandId(1)
                .price(35.50)
                .priceList(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00", formatter))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59", formatter))
                .build();
        String expectedJsonProductPrice = new ObjectMapper().findAndRegisterModules().writeValueAsString(expectedDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/ApiProduct/price")
                        .param("brandId", brandId_param)
                        .param("prdId", productId_param)
                        .param("date", date_param)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJsonProductPrice))
                .andReturn();
    }

    @Test
    public void testProductControllerGetProductPriceStatus400() throws Exception {

        final String brandId_param = "1";
        final String productId_param = "35455";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/ApiProduct/price")
                        .param("brandId", brandId_param)
                        .param("prdId", productId_param)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void testProductControllerGetProductPriceStatus404() throws Exception {

        final String brandId_param = "1";
        final String productId_param = "9999";
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        final String date_param = LocalDateTime.parse("2020-06-14T10:00:00").format(formatter);
        final String expectedAdvisorMessage = " {\"code\":\"E100\",\"message\":\"The resource cannot be found\"}";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/ApiProduct/price")
                        .param("brandId", brandId_param)
                        .param("prdId", productId_param)
                        .param("date", date_param)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().json(expectedAdvisorMessage))
                .andReturn();
    }

}
