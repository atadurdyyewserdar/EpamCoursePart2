package com.company.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RatingDao {
    private static Logger logger = LogManager.getLogger();
    private static final String SELECT_ALL = "SELECT idRating, stars, rating, User_idUser, Movie_idMovie from movie_rating.rating";
    private static final String SELECT_BY_ID = "SELECT idRating, stars, rating, User_idUser, Movie_idMovie from movie_rating.rating where idRating =?";

}
