package com.tikim.org.musinsa.domain.brand.controller;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;
import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerUpdateRequest;
import com.tikim.org.musinsa.domain.brand.controller.dto.response.*;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceUpdateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.response.*;
import com.tikim.org.musinsa.global.application.dto.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return ResponseEntity.ok(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BrandControllerReadResponse>> getBrandById(@PathVariable Long id) {
        BrandServiceReadResponse serviceResponse = brandService.getBrandById(id);
        BrandControllerReadResponse response = BrandControllerReadResponse.from(serviceResponse);
        return ResponseEntity.ok(ApiResponse.success(response, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BrandControllerCreateResponse>> createBrand(@RequestBody BrandControllerCreateRequest request) {
        BrandServiceCreateRequest serviceRequest = BrandServiceCreateRequest.from(request);
        BrandServiceCreateResponse serviceResponse = brandService.createBrand(serviceRequest);
        BrandControllerCreateResponse response = BrandControllerCreateResponse.from(serviceResponse);
        return ResponseEntity.ok(ApiResponse.success(response, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BrandControllerUpdateResponse>> updateBrand(@PathVariable Long id, @RequestBody BrandControllerUpdateRequest request) {
        BrandServiceUpdateRequest serviceRequest = BrandServiceUpdateRequest.from(request);
        BrandServiceUpdateResponse serviceResponse = brandService.updateBrand(id, serviceRequest);
        BrandControllerUpdateResponse response = BrandControllerUpdateResponse.from(serviceResponse);
        return ResponseEntity.ok(ApiResponse.success(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return ResponseEntity.ok(ApiResponse.success());
    }
}
