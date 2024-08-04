package com.tikim.org.musinsa.unit.brand.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerUpdateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceUpdateRequest;

public class BrandControllerUpdateRequestTest {

    @Test
    @DisplayName("BrandControllerUpdateRequest -> BrandServiceUpdateRequest 변환 테스트")
    void testFrom() {
        BrandControllerUpdateRequest controllerRequest = new BrandControllerUpdateRequest();
        controllerRequest.setName("Updated Brand");

        BrandServiceUpdateRequest serviceRequest = BrandServiceUpdateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getName(), serviceRequest.getName());
    }
}
