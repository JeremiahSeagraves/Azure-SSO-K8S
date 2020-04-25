package com.jeremiahseagraves.cloud.azuressok8s.domain;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class APIResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private Object result;
}
