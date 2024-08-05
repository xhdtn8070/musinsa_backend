package com.tikim.org.musinsa.integration.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.tikim.org.musinsa.integration.product.util.TestSetupUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;

@SpringBootTest
@Transactional
public class ProductServiceGetMinPriceByBrandIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestSetupUtil testSetupUtil;

    @BeforeEach
    void setUp() {
        testSetupUtil.setUp();
    }

    @Test
    @DisplayName("브랜드별 최소 가격 상품 조회 통합 테스트")
    void testGetMinPriceByBrand() {
        ProductServiceMinPriceByBrandResponse response = productService.getMinPriceProductsByBrand();

        assertNotNull(response);
        assertEquals("D", response.getBrandName());
        assertNotNull(response.getCategoryPrices());
        assertEquals(8, response.getCategoryPrices().size());

        response.getCategoryPrices().forEach(categoryPrice -> {
            switch (categoryPrice.getCategory()) {
                case "상의":
                    assertEquals(10100, categoryPrice.getPrice());
                    break;
                case "아우터":
                    assertEquals(5100, categoryPrice.getPrice());
                    break;
                case "바지":
                    assertEquals(3000, categoryPrice.getPrice());
                    break;
                case "스니커즈":
                    assertEquals(9500, categoryPrice.getPrice());
                    break;
                case "가방":
                    assertEquals(2500, categoryPrice.getPrice());
                    break;
                case "모자":
                    assertEquals(1500, categoryPrice.getPrice());
                    break;
                case "양말":
                    assertEquals(2400, categoryPrice.getPrice());
                    break;
                case "액세서리":
                    assertEquals(2000, categoryPrice.getPrice());
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected category: " + categoryPrice.getCategory());
            }
        });

        assertEquals(36100, response.getTotalAmount());
    }
}
