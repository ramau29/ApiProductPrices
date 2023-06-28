package com.exercise.ApiPrices.repository;

import com.exercise.ApiPrices.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<Price, Long> {
    @Query("SELECT p FROM Price p " +
            "WHERE p.brandId = ?1 AND p.productId = ?2 AND ?3 BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
    List<Price> findProducts(long brandId, long productId, LocalDateTime date);


}
