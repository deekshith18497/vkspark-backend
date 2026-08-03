package com.vkspark.vkspark_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long totalMovies;
    private long totalTheatres;
    private long totalScreens;
    private long totalShows;
    private long totalBookings;
    private double totalRevenue;

}