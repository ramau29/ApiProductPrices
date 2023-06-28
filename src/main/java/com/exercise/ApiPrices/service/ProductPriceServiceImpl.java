package com.exercise.ApiPrices.service;

import com.exercise.ApiPrices.model.dto.ProductPriceDTO;
import com.exercise.ApiPrices.repository.ProductPriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductPriceServiceImpl implements IProductPriceService {

    ProductPriceRepository repository;

    public ProductPriceServiceImpl(ProductPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductPriceDTO findProductPrice(long brandId, long productId, LocalDateTime date) {
        var product = repository.findProducts(brandId, productId, date).stream().findFirst().orElseThrow();
        return ProductPriceDTO.builder()
                .price(product.getPrice())
                .priceList(product.getPriceList())
                .productId(product.getProductId())
                .brandId(product.getBrandId())
                .endDate(product.getEndDate())
                .startDate(product.getStartDate())
                .build();
    }
}
