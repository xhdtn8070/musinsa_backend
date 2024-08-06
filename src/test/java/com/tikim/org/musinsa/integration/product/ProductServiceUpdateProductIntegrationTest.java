package com.tikim.org.musinsa.integration.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceUpdateResponse;
import com.tikim.org.musinsa.global.cache.service.GlobalCacheService;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ProductServiceUpdateProductIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GlobalCacheService globalCacheService;

    private final Long nonExistentId = -1L;

    private Long savedProductId;
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

        Product product = productRepository.save(Product.builder()
            .category(category)
            .brand(brand)
            .price(1000)
            .build());

        savedProductId = product.getId();
        globalCacheService.evictAllCaches();
    }

    @Test
    @DisplayName("상품 업데이트 통합 테스트")
    void testUpdateProduct() {
        ProductServiceUpdateRequest request = ProductServiceUpdateRequest.builder()
            .categoryId(savedCategoryId)
            .brandId(savedBrandId)
            .price(2000)
            .build();

        ProductServiceUpdateResponse response = productService.updateProduct(savedProductId, request);

        assertEquals(savedProductId, response.getId());
        assertEquals(2000, response.getPrice());

        Product updatedProduct = productRepository.findById(savedProductId).orElse(null);
        assertNotNull(updatedProduct);
        assertEquals(2000, updatedProduct.getPrice());
    }

    @Test
    @DisplayName("존재하지 않는 상품 업데이트 시 예외 발생 테스트")
    void testUpdateProduct_NotFound() {
        ProductServiceUpdateRequest request = ProductServiceUpdateRequest.builder()
            .categoryId(savedCategoryId)
            .brandId(savedBrandId)
            .price(2000)
            .build();

        assertThrows(ProductException.class, () -> productService.updateProduct(nonExistentId, request));
    }
}
