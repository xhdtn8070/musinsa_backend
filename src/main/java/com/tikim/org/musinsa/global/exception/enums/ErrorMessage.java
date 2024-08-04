package com.tikim.org.musinsa.global.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    UNDEFINED_EXCEPTION("정의되지 않은 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    CATEGORY_ALREADY_EXIST("이미 존재하는 카테고리입니다.", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_EXIST("존재하지 않는 카테고리입니다.", HttpStatus.BAD_REQUEST),
    CATEGORY_NAME_ALREADY_EXIST("이미 존재하는 카테고리명입니다.", HttpStatus.BAD_REQUEST),
    MIN_PRICE_NOT_FOUND("최소 가격을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    MAX_PRICE_NOT_FOUND("최대 가격을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    PRODUCT_NOT_EXIST("존재하지 않는 상품입니다.", HttpStatus.NOT_FOUND),
    BRAND_ALREADY_EXIST("이미 존재하는 브랜드입니다.", HttpStatus.BAD_REQUEST),
    BRAND_NOT_EXIST("존재하지 않는 브랜드입니다.", HttpStatus.NOT_FOUND),
    INVALID_REQUEST("잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_ACCESS("접근 권한이 없습니다.", HttpStatus.UNAUTHORIZED),
    FORBIDDEN_ACCESS("접근이 금지되었습니다.", HttpStatus.FORBIDDEN),
    INTERNAL_SERVER_ERROR("서버 내부 오류입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    SERVICE_UNAVAILABLE("서비스를 사용할 수 없습니다.", HttpStatus.SERVICE_UNAVAILABLE),
    CATEGORY_HAS_PRODUCTS("해당 카테고리에 상품이 존재합니다.", HttpStatus.BAD_REQUEST),
    BRAND_HAS_PRODUCTS("해당 브랜드에 상품이 존재합니다.", HttpStatus.BAD_REQUEST),

    ;

    private final String errorMessage;
    private final HttpStatus httpStatus;
}
