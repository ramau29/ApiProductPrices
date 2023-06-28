package com.exercise.ApiPrices.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class ProductPriceDTO {

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("brand_id")
    private long brandId;

    private Double price;

    @JsonProperty("price_list")
    private int priceList;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;
}
