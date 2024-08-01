package com.tikim.org.musinsa.global.exception.handler;

import com.tikim.org.musinsa.global.exception.exceptions.BaseException;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.exceptions.UndefinedException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final Set<String> exceptionSet = new HashSet<>();

    @PostConstruct
    public void init() {
        exceptionSet.add("NoHandlerFoundException");
        exceptionSet.add("HttpRequestMethodNotSupportedException");
        exceptionSet.add("DateTimeParseException");
        exceptionSet.add("MethodArgumentTypeMismatchException");
        exceptionSet.add("ConstraintViolationException");
        exceptionSet.add("ClientAbortException");
        exceptionSet.add("WebClientResponseException");
        exceptionSet.add("BadRequest");
        exceptionSet.add("IOException");
        exceptionSet.add("HttpMediaTypeNotAcceptableException");
        exceptionSet.add("MissingServletRequestParameterException");
    }

    // 모든 예외를 처리하는 기본 핸들러
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<BaseException> handleDefaultException(Throwable e) {
        BaseException baseException = determineBaseException(e);
        return createResponseEntity(baseException);
    }

    // 예외의 종류를 판단하여 적절한 BaseException을 생성 및 반환하는 메서드
    private BaseException determineBaseException(Throwable e) {
        if (e instanceof BaseException) {
            return (BaseException) e;
        } else {
            UndefinedException baseException = new UndefinedException(e);
            if (exceptionSet.contains(baseException.getClassName())) {
                baseException.setCriticalLevel(CriticalLevel.NON_CRITICAL);
            }
            return baseException;
        }
    }

    // BaseException을 기반으로 ResponseEntity를 생성하는 메서드
    private ResponseEntity<BaseException> createResponseEntity(BaseException e) {
        return new ResponseEntity<>(e, e.getHttpStatus());
    }
}
