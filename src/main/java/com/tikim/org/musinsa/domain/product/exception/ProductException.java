package com.tikim.org.musinsa.domain.product.exception;

import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import com.tikim.org.musinsa.global.exception.exceptions.BaseException;

public class ProductException extends BaseException {
    public ProductException(ErrorMessage errorMessage, CriticalLevel criticalLevel) {
        super(errorMessage, criticalLevel);
    }

    public ProductException(ErrorMessage errorMessage, CriticalLevel criticalLevel, String additionalInfo) {
        super(errorMessage, criticalLevel, additionalInfo);
    }
}
