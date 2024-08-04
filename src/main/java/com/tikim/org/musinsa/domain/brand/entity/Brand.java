package com.tikim.org.musinsa.domain.brand.entity;

import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;

    public static Brand from(CreateBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        return brand;
    }

    public void update(UpdateBrandRequest request) {
        this.setName(request.getName());
    }
}
