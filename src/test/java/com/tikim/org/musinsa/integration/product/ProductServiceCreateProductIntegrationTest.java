package com.tikim.org.musinsa.integration.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCreateResponse;

@SpringBootTest
@Transactional
public class ProductServiceCreateProductIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Long savedBrandId;
    private Long savedCategoryId;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        brandRepository.deleteAll();
        categoryRepository.deleteAll();

        productRepository.flush();
        brandRepository.flush();
        categoryRepository.flush();

        Brand brand = brandRepository.save(Brand.builder().name("Test Brand").build());
        Category category = categoryRepository.save(Category.builder().name("Test Category").build());

        savedBrandId = brand.getId();
        savedCategoryId = category.getId();
    }

    @Test
    @DisplayName("상품 생성 통합 테스트")
    void testCreateProduct() {
        ProductServiceCreateRequest request = ProductServiceCreateRequest.builder()
            .categoryId(savedCategoryId)
            .brandId(savedBrandId)
            .price(1000)
            .build();

        ProductServiceCreateResponse response = productService.createProduct(request);

        assertNotNull(response.getId());
        assertEquals(1000, response.getPrice());

        Product savedProduct = productRepository.findById(response.getId()).orElse(null);
        assertNotNull(savedProduct);
        assertEquals(1000, savedProduct.getPrice());
    }
}
