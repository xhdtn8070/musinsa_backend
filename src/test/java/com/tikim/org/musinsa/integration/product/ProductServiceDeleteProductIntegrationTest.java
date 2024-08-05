package com.tikim.org.musinsa.integration.product;

import static org.junit.jupiter.api.Assertions.assertThrows;

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
import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.product.service.ProductService;

@SpringBootTest
@Transactional
public class ProductServiceDeleteProductIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
    }

    @Test
    @DisplayName("상품 삭제 통합 테스트")
    void testDeleteProduct() {
        productService.deleteProductById(savedProductId);

        assertThrows(ProductException.class, () -> productService.getProductById(savedProductId));
    }

    @Test
    @DisplayName("존재하지 않는 상품 삭제 시 예외 발생 테스트")
    void testDeleteProduct_NotFound() {
        assertThrows(ProductException.class, () -> productService.deleteProductById(-1L));
    }
}
