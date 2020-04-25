package com.jeremiahseagraves.cloud.azuressok8s.controller;

import com.jeremiahseagraves.cloud.azuressok8s.domain.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {


    @GetMapping(value = "/")
    public ResponseEntity<APIResponse> helloWorld(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getUserPrincipal());
        String userName = httpServletRequest.getUserPrincipal().getName();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setResult(
                "Hello World!, You are: " + userName +
                        " You are inside the group: Test Group in Azure's Active Directory of JeremiahSeagraves.onmicrosoft.com tenant");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping(value = "/unsecured")
    public ResponseEntity<APIResponse> helloWorldUnsecured(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getUserPrincipal());
        String userName = httpServletRequest.getUserPrincipal().getName();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setStatusCode(HttpStatus.OK.value());
        apiResponse.setResult(
                "Hello World Unsecured!, You are: " + userName + " " +
                        "This endpoint is unsecured. " +
                        "You are not inside any Group in Azure's Active Directory of JeremiahSeagraves.onmicrosoft.com tenant");
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
