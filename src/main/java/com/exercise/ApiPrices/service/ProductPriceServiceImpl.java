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
        return repository.findProducts(brandId, productId, date).stream()
                .findFirst()
                .orElseThrow()
                .toDTO();
    }
}
// E100 [The resource cannot be found] - NoSuchElementException - 500 Internal Server Error
// E101 [The request cannot be fulfilled due to bad syntax.] - MethodArgumentTypeMismatchException - 400 Bad Request -
// E102 [There is som problem with the database connection.] - DataAccessException -