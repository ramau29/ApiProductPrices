package com.exercise.ApiPrices.service;

import com.exercise.ApiPrices.model.dto.ProductPriceDTO;

import java.time.LocalDateTime;
import java.util.Date;

public interface IProductPriceService {

    public ProductPriceDTO findProductPrice(long brandId, long productId, LocalDateTime date);
}
