package com.wandr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Health and root endpoints.
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/")
    public Map<String, Object> root() {
        return Map.of(
                "service", "Wandr API",
                "status", "ok",
                "version", "0.1.0"
        );
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of("status", "healthy");
    }
}
