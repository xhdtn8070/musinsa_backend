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

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCategoryMinMaxPriceResponse;

@SpringBootTest
@Transactional
public class ProductServiceGetCategoryMinMaxPriceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestSetupUtil testSetupUtil;

    @BeforeEach
    void setUp() {
        testSetupUtil.setUp();
    }

    @Test
    @DisplayName("카테고리별 최소/최대 가격 상품 조회 통합 테스트")
    void testGetCategoryMinMaxPrice() {
        // 상의 카테고리 테스트
        ProductServiceCategoryMinMaxPriceResponse response = productService.getCategoryMinMaxPrice("상의");
        assertNotNull(response);
        assertEquals("상의", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("C", response.getMinPrice().getBrandName());
        assertEquals(10000, response.getMinPrice().getPrice());
        assertEquals("I", response.getMaxPrice().getBrandName());
        assertEquals(11400, response.getMaxPrice().getPrice());

        // 가방 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("가방");
        assertNotNull(response);
        assertEquals("가방", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("A", response.getMinPrice().getBrandName());
        assertEquals(2000, response.getMinPrice().getPrice());
        assertEquals("D", response.getMaxPrice().getBrandName());
        assertEquals(2500, response.getMaxPrice().getPrice());

        // 모자 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("모자");
        assertNotNull(response);
        assertEquals("모자", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("D", response.getMinPrice().getBrandName());
        assertEquals(1500, response.getMinPrice().getPrice());
        assertEquals("B", response.getMaxPrice().getBrandName());
        assertEquals(2000, response.getMaxPrice().getPrice());

        // 바지 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("바지");
        assertNotNull(response);
        assertEquals("바지", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("D", response.getMinPrice().getBrandName());
        assertEquals(3000, response.getMinPrice().getPrice());
        assertEquals("A", response.getMaxPrice().getBrandName());
        assertEquals(4200, response.getMaxPrice().getPrice());

        // 스니커즈 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("스니커즈");
        assertNotNull(response);
        assertEquals("스니커즈", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("G", response.getMinPrice().getBrandName());
        assertEquals(9000, response.getMinPrice().getPrice());
        assertEquals("E", response.getMaxPrice().getBrandName());
        assertEquals(9900, response.getMaxPrice().getPrice());

        // 아우터 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("아우터");
        assertNotNull(response);
        assertEquals("아우터", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("E", response.getMinPrice().getBrandName());
        assertEquals(5000, response.getMinPrice().getPrice());
        assertEquals("F", response.getMaxPrice().getBrandName());
        assertEquals(7200, response.getMaxPrice().getPrice());

        // 액세서리 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("액세서리");
        assertNotNull(response);
        assertEquals("액세서리", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("F", response.getMinPrice().getBrandName());
        assertEquals(1900, response.getMinPrice().getPrice());
        assertEquals("I", response.getMaxPrice().getBrandName());
        assertEquals(2400, response.getMaxPrice().getPrice());

        // 양말 카테고리 테스트
        response = productService.getCategoryMinMaxPrice("양말");
        assertNotNull(response);
        assertEquals("양말", response.getCategoryName());
        assertNotNull(response.getMinPrice());
        assertNotNull(response.getMaxPrice());
        assertEquals("I", response.getMinPrice().getBrandName());
        assertEquals(1700, response.getMinPrice().getPrice());
        assertEquals("D", response.getMaxPrice().getBrandName());
        assertEquals(2400, response.getMaxPrice().getPrice());
    }

}
