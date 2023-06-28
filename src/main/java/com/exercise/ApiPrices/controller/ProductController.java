package com.exercise.ApiPrices.controller;

import com.exercise.ApiPrices.model.dto.ProductPriceDTO;
import com.exercise.ApiPrices.service.ProductPriceServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/ApiProduct")
public class ProductController {

    private ProductPriceServiceImpl service;

    public ProductController(ProductPriceServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = "/hola")
    public String hola() {
        return "HOOOOOLLLLLAAAAAAAAAA";
    }

    @GetMapping(path = "/price")
    public ProductPriceDTO getProductPrice(@RequestParam("brandId") long brandId,
                                           @RequestParam("prdId") long productId,
                                           @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
        return  this.service.findProductPrice(brandId, productId, date);
    }
}
