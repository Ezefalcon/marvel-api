package com.openpay.marvelapi.controller;

import com.openpay.marvelapi.model.LogRequest;
import com.openpay.marvelapi.service.LogRequestService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@AllArgsConstructor
public class LogRequestController {

    private final LogRequestService logRequestService;

    @GetMapping
    public Page<LogRequest> getLogs(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                          @RequestParam(name = "limit", required = false, defaultValue = "20") Integer limit) {
        return logRequestService.findAll(page, limit);
    }
}
