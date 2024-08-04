package com.tikim.org.musinsa.domain.brand.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;
import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerUpdateRequest;
import com.tikim.org.musinsa.domain.brand.controller.dto.response.BrandControllerReadResponse;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceUpdateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import com.tikim.org.musinsa.global.application.dto.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BrandControllerReadResponse>>> getAllBrands() {
        List<BrandServiceReadResponse> serviceResponse = brandService.getAllBrands();
        List<BrandControllerReadResponse> response = serviceResponse.stream()
            .map(BrandControllerReadResponse::from)
            .collect(Collectors.toList());
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BrandControllerReadResponse>> getBrandById(@PathVariable Long id) {
        BrandServiceReadResponse serviceResponse = brandService.getBrandById(id);
        BrandControllerReadResponse response = BrandControllerReadResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BrandControllerReadResponse>> createBrand(@RequestBody BrandControllerCreateRequest request) {
        BrandServiceCreateRequest serviceRequest = BrandServiceCreateRequest.from(request);
        BrandServiceReadResponse serviceResponse = brandService.createBrand(serviceRequest);
        BrandControllerReadResponse response = BrandControllerReadResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BrandControllerReadResponse>> updateBrand(@PathVariable Long id, @RequestBody BrandControllerUpdateRequest request) {
        BrandServiceUpdateRequest serviceRequest = BrandServiceUpdateRequest.from(request);
        BrandServiceReadResponse serviceResponse = brandService.updateBrand(id, serviceRequest);
        BrandControllerReadResponse response = BrandControllerReadResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return ApiResponse.toResponseEntity(ApiResponse.success());
    }
}
