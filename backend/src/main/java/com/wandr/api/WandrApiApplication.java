package com.wandr.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Wandr API — main entry point.
 *
 * Run locally:
 *   mvn spring-boot:run
 *
 * Then visit:
 *   http://localhost:8080/
 *   http://localhost:8080/api/cities
 *   http://localhost:8080/api/health
 */
@SpringBootApplication
public class WandrApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WandrApiApplication.class, args);
    }
}
