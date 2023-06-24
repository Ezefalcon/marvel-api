package com.openpay.marvelapi.config;

import com.openpay.marvelapi.model.LogRequest;
import com.openpay.marvelapi.repository.LogRequestRepository;
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

    private final LogRequestRepository logRequestRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LogRequest logRequest = new LogRequest();
        logRequest.setUrl(request.getRequestURI());
        logRequest.setUsername(request.getUserPrincipal().getName());
        logRequest.setLocalDateTime(LocalDateTime.now());
        logRequestRepository.save(logRequest);
        filterChain.doFilter(request, response);
    }
}
