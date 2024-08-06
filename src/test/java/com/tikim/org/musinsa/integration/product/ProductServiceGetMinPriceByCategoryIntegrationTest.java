package com.tikim.org.musinsa.integration.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByCategoryResponse;
import com.tikim.org.musinsa.global.cache.service.GlobalCacheService;
import com.tikim.org.musinsa.integration.product.util.TestSetupUtil;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ProductServiceGetMinPriceByCategoryIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private TestSetupUtil testSetupUtil;

    @Autowired
    private GlobalCacheService globalCacheService;

    @BeforeEach
    void setUp() {
        testSetupUtil.setUp();
        globalCacheService.evictAllCaches();
    }

    @Test
    @DisplayName("카테고리별 최소 가격 상품 조회 통합 테스트")
    void testGetMinPriceByCategory() {
        List<ProductServiceMinPriceByCategoryResponse> response = productService.getMinPriceProductsByCategory();

        assertNotNull(response);
        assertEquals(8, response.size());

        response.forEach(item -> {
            assertNotNull(item.getCategoryName());
            assertNotNull(item.getBrandName());
            assertNotNull(item.getPrice());

            switch (item.getCategoryName()) {
                case "상의":
                    assertEquals("C", item.getBrandName());
                    assertEquals(10000, item.getPrice());
                    break;
                case "아우터":
                    assertEquals("E", item.getBrandName());
                    assertEquals(5000, item.getPrice());
                    break;
                case "바지":
                    assertEquals("D", item.getBrandName());
                    assertEquals(3000, item.getPrice());
                    break;
                case "스니커즈":
                    assertEquals("G", item.getBrandName());
                    assertEquals(9000, item.getPrice());
                    break;
                case "가방":
                    assertEquals("A", item.getBrandName());
                    assertEquals(2000, item.getPrice());
                    break;
                case "모자":
                    assertEquals("D", item.getBrandName());
                    assertEquals(1500, item.getPrice());
                    break;
                case "양말":
                    assertEquals("I", item.getBrandName());
                    assertEquals(1700, item.getPrice());
                    break;
                case "액세서리":
                    assertEquals("F", item.getBrandName());
                    assertEquals(1900, item.getPrice());
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected category: " + item.getCategoryName());
            }
        });
    }
}
