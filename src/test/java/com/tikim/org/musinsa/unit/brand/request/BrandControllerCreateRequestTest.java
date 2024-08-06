package com.tikim.org.musinsa.unit.brand.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;

@SpringBootTest
@ActiveProfiles("test")
public class BrandControllerCreateRequestTest {

    @Test
    @DisplayName("BrandControllerCreateRequest -> BrandServiceCreateRequest 변환 테스트")
    void testCreateRequestConversion() {
        BrandControllerCreateRequest controllerRequest = BrandControllerCreateRequest.builder()
            .name("Test Brand")
            .build();

        BrandServiceCreateRequest serviceRequest = BrandServiceCreateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getName(), serviceRequest.getName());
    }
}
