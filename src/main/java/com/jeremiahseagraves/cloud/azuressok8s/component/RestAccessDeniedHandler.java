package com.jeremiahseagraves.cloud.azuressok8s.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeremiahseagraves.cloud.azuressok8s.domain.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        APIResponse response = new APIResponse();
        response.setStatus(HttpStatus.FORBIDDEN);
        response.setStatusCode(HttpStatus.FORBIDDEN.value());
        response.setMessage("Access Denied");
        OutputStream out = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, response);
        out.flush();
    }
}
