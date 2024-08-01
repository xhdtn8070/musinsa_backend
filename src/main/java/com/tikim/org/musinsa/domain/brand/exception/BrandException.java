package com.tikim.org.musinsa.domain.brand.exception;

import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import com.tikim.org.musinsa.global.exception.exceptions.BaseException;

public class BrandException extends BaseException {
    public BrandException(ErrorMessage errorMessage, CriticalLevel criticalLevel) {
        super(errorMessage, criticalLevel);
    }

    public BrandException(ErrorMessage errorMessage, CriticalLevel criticalLevel, String additionalInfo) {
        super(errorMessage, criticalLevel, additionalInfo);
    }
}
