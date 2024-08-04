package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceUpdateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceUpdateResponse from(Product product) {
        ProductServiceUpdateResponse response = new ProductServiceUpdateResponse();
        response.setId(product.getId());
        response.setCategoryId(product.getCategory().getId());
        response.setBrandId(product.getBrand().getId());
        response.setPrice(product.getPrice());
        return response;
    }
}