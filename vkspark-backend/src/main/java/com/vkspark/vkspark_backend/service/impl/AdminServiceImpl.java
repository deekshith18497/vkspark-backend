package com.vkspark.vkspark_backend.service.impl;

import org.springframework.stereotype.Service;

import com.vkspark.vkspark_backend.dto.DashboardResponse;
import com.vkspark.vkspark_backend.repository.BookingRepository;
import com.vkspark.vkspark_backend.repository.MovieRepository;
import com.vkspark.vkspark_backend.repository.PaymentRepository;
import com.vkspark.vkspark_backend.repository.ScreenRepository;
import com.vkspark.vkspark_backend.repository.ShowRepository;
import com.vkspark.vkspark_backend.repository.TheatreRepository;
import com.vkspark.vkspark_backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ScreenRepository screenRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;

    public AdminServiceImpl(MovieRepository movieRepository,
                            TheatreRepository theatreRepository,
                            ScreenRepository screenRepository,
                            ShowRepository showRepository,
                            BookingRepository bookingRepository,
                            PaymentRepository paymentRepository) {

        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.screenRepository = screenRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public DashboardResponse getDashboard() {

        DashboardResponse dashboard = new DashboardResponse();

        dashboard.setTotalMovies(movieRepository.count());

        dashboard.setTotalTheatres(theatreRepository.count());

        dashboard.setTotalScreens(screenRepository.count());

        dashboard.setTotalShows(showRepository.count());

        dashboard.setTotalBookings(bookingRepository.count());

        Double revenue = paymentRepository.getTotalRevenue();

        dashboard.setTotalRevenue(revenue == null ? 0 : revenue);

        return dashboard;
    }

}
