package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Show;

import java.util.List;

public interface ShowService {

    Show saveShow(Show show);

    List<Show> getAllShows();

}