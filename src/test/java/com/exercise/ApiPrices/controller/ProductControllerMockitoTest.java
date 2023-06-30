package com.exercise.ApiPrices.controller;

import com.exercise.ApiPrices.model.dto.ProductPriceDTO;
import com.exercise.ApiPrices.service.ProductPriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerMockitoTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductPriceServiceImpl productPriceService;

    @Test
    public void metodo(){
        //Given
        final long brandId_param = 1;
        final long productId_param = 35455;
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        final LocalDateTime date_param = LocalDateTime.parse("2020-06-14T10:00:00", formatter);
        ProductPriceDTO expectedDTO = ProductPriceDTO.builder()
                .productId(35455)//35455
                .brandId(1)
                .priceList(1)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00", formatter))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59", formatter))
                .build();

        //When
        when(productPriceService.findProductPrice(brandId_param, productId_param, date_param)).thenReturn(expectedDTO);

        ProductPriceDTO result = productController.getProductPrice(brandId_param, productId_param, date_param);

        //Then
        Assertions.assertEquals(result.getProductId(), expectedDTO.getProductId());
        Assertions.assertEquals(result.getPrice(), expectedDTO.getPrice());
        Assertions.assertEquals(result.getStartDate(), expectedDTO.getStartDate());
        Assertions.assertEquals(result.getEndDate(), expectedDTO.getEndDate());
        verify(productPriceService).findProductPrice(brandId_param, productId_param, date_param);
    }
}
