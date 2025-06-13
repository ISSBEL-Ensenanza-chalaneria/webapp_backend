package com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.utils;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.ApiResponse;
import com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response.HttpResponse;

public class ResponseUtil {
    public static ApiResponse response(int controlFlow) {
        return ApiResponse.builder()
                .controlFlow(controlFlow)
                .build();
    }

    public static ApiResponse response(int controlFlow, Optional<?> data) {
        return ApiResponse.builder()
                .controlFlow(controlFlow)
                .data(data)
                .build();
    }

    public static ResponseEntity<HttpResponse> httpResponse(String message, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus.value())
                        .body(
                                        HttpResponse.builder()
                                                        .timeStamp(LocalDateTime.now().toString())
                                                        .message(message)
                                                        .status(httpStatus)
                                                        .statusCode(httpStatus.value())
                                                        .build());
    }

    public static <T> ResponseEntity<HttpResponse> httpResponse(String message, HttpStatus httpStatus,
            String dataName, T data) {
        return ResponseEntity.status(httpStatus.value())
                .body(
                        HttpResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .message(message)
                                .data(Map.of(dataName, data))
                                .status(httpStatus)
                                .statusCode(httpStatus.value())
                                .build());
    }
}
