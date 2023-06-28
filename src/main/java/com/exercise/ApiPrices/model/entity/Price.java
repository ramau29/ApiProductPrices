package com.exercise.ApiPrices.model.entity;


import com.exercise.ApiPrices.model.dto.ProductPriceDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Getter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

    public ProductPriceDTO toDTO() {
        return ProductPriceDTO.builder()
                .price(this.getPrice())
                .priceList(this.getPriceList())
                .productId(this.getProductId())
                .brandId(this.getBrandId())
                .endDate(this.getEndDate())
                .startDate(this.getStartDate())
                .build();
    }
}
