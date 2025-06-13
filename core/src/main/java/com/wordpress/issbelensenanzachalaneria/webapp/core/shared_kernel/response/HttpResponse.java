package com.wordpress.issbelensenanzachalaneria.webapp.core.shared_kernel.response;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(content = JsonInclude.Include.NON_DEFAULT, value = JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class HttpResponse {
    private String timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String reason;
    private String message;
    private String devMessage;
    private Map<?, ?> data;
}
