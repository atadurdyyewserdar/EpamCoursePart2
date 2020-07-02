package com.company.entity;

import java.util.Objects;

public class Rating {
    private int idRating;
    private String stars;
    private Double rating;
    private int userId;
    private int movieId;

    public Rating(int idRating, String stars, Double rating, int userId, int movieId) {
        this.idRating = idRating;
        this.stars = stars;
        this.rating = rating;
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return idRating == rating1.idRating &&
                userId == rating1.userId &&
                movieId == rating1.movieId &&
                stars.equals(rating1.stars) &&
                rating.equals(rating1.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRating, stars, rating, userId, movieId);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", stars='" + stars + '\'' +
                ", rating=" + rating +
                ", userId=" + userId +
                ", movieId=" + movieId +
                '}';
    }
}
