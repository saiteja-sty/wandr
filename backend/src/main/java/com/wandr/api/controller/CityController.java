package com.wandr.api.controller;

import com.wandr.api.model.City;
import com.wandr.api.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * /api/cities — list cities Wandr supports.
 */
@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> list(@RequestParam(required = false) String status) {
        return (status == null) ? cityService.findAll() : cityService.findByStatus(status);
    }
}
