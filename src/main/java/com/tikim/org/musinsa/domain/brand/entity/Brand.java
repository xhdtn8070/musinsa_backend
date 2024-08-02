package com.tikim.org.musinsa.domain.brand.entity;

import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static Brand from(CreateBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        return brand;
    }

    public void update(UpdateBrandRequest request) {
        this.setName(request.getName());
    }
}
