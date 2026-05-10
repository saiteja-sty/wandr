package com.wandr.api.service;

import com.wandr.api.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * In-memory CityService. In Phase C, this will be backed by PostgreSQL.
 */
@Service
public class CityService {

    private static final List<City> CITIES = List.of(
            new City("Boston",        "Massachusetts",   "live",         42.3601, -71.0589, "MBTA"),
            new City("New York",      "New York",        "live",         40.7128, -74.0060, "MTA"),
            new City("Chicago",       "Illinois",        "coming_soon",  41.8781, -87.6298, "CTA"),
            new City("San Francisco", "California",      "coming_soon",  37.7749, -122.4194,"BART/Muni"),
            new City("Washington",    "D.C.",            "in_progress",  38.9072, -77.0369, "WMATA"),
            new City("Seattle",       "Washington",      "in_progress",  47.6062, -122.3321,"Sound Transit"),
            new City("Austin",        "Texas",           "vote_next",    30.2672, -97.7431, "CapMetro"),
            new City("Philadelphia",  "Pennsylvania",    "vote_next",    39.9526, -75.1652, "SEPTA")
    );

    public List<City> findAll() {
        return CITIES;
    }

    public List<City> findByStatus(String status) {
        return CITIES.stream().filter(c -> c.getStatus().equals(status)).toList();
    }
}
