package com.exercise.ApiPrices.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    private Integer id;
    private String name;
}
