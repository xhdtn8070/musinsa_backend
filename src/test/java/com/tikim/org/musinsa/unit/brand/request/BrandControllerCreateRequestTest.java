package com.tikim.org.musinsa.unit.brand.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;

public class BrandControllerCreateRequestTest {

    @Test
    @DisplayName("BrandControllerCreateRequest -> BrandServiceCreateRequest 변환 테스트")
    void testFrom() {
        BrandControllerCreateRequest controllerRequest = new BrandControllerCreateRequest();
        controllerRequest.setName("Test Brand");

        BrandServiceCreateRequest serviceRequest = BrandServiceCreateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getName(), serviceRequest.getName());
    }
}
