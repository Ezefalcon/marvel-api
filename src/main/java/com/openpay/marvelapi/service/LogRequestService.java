package com.openpay.marvelapi.service;

import com.openpay.marvelapi.model.LogRequest;
import com.openpay.marvelapi.repository.LogRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogRequestService {

    private final LogRequestRepository logRequestRepository;

    public LogRequest save(LogRequest logRequest) {
        return logRequestRepository.save(logRequest);
    }

    public Page<LogRequest> findAll(int page, int limit) {
        return logRequestRepository.findAll(PageRequest.of(page, limit));
    }

}
