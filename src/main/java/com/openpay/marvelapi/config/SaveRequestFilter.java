package com.openpay.marvelapi.config;

import com.openpay.marvelapi.model.LogRequest;
import com.openpay.marvelapi.service.LogRequestService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class SaveRequestFilter extends OncePerRequestFilter {

    private final LogRequestService logRequestService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LogRequest logRequest = new LogRequest();
        logRequest.setUrl(request.getRequestURI());
        if (request.getUserPrincipal() != null) {
            logRequest.setUsername(request.getUserPrincipal().getName());
        }
        logRequest.setDate(LocalDateTime.now());
        logRequestService.save(logRequest);
        filterChain.doFilter(request, response);
    }
}
