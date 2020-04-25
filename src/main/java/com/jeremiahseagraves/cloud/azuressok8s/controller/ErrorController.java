package com.jeremiahseagraves.cloud.azuressok8s.controller;

import com.jeremiahseagraves.cloud.azuressok8s.domain.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public APIResponse handleNoHandlerFoundException(NoHandlerFoundException ex) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.NOT_FOUND);
        apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiResponse.setMessage("Specified path not found on this server");
        return apiResponse;
    }
}
