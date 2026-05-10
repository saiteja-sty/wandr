package com.wandr.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a city Wandr supports.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private String name;
    private String region;
    private String status;       // "live", "coming_soon", "in_progress", "vote_next"
    private double latitude;
    private double longitude;
    private String transitName;  // e.g. "MBTA", "MTA"
}
