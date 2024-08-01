package com.tikim.org.musinsa.domain.category.exception;

import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import com.tikim.org.musinsa.global.exception.exceptions.BaseException;

public class CategoryException extends BaseException {
    public CategoryException(ErrorMessage errorMessage, CriticalLevel criticalLevel) {
        super(errorMessage, criticalLevel);
    }

    public CategoryException(ErrorMessage errorMessage, CriticalLevel criticalLevel, String additionalInfo) {
        super(errorMessage, criticalLevel, additionalInfo);
    }
}
