package com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response;

import java.util.Optional;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private int controlFlow;
    private Optional<?> data;
}
