package database;

import fileio.MovieInput;

import java.util.ArrayList;

public final class Movie {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes;
    private float rating;
    private int numRatings;
    private int totalRating;

    public Movie(final Movie movie) {
        name = movie.getName();
        year = movie.getYear();
        duration = movie.getDuration();
        genres = new ArrayList<>(movie.getGenres());
        actors = new ArrayList<>(movie.getActors());
        countriesBanned = new ArrayList<>(movie.getCountriesBanned());
        numLikes = movie.getNumLikes();
        rating = movie.getRating();
        numRatings = movie.getNumRatings();
        totalRating = movie.getTotalRating();
    }

    public Movie(final MovieInput movie) {
        name = movie.getName();
        year = movie.getYear();
        duration = movie.getDuration();
        genres = new ArrayList<>(movie.getGenres());
        actors = new ArrayList<>(movie.getActors());
        countriesBanned = new ArrayList<>(movie.getCountriesBanned());
        numLikes = 0;
        rating = 0;
        numRatings = 0;
        totalRating = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(final float rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(final int totalRating) {
        this.totalRating = totalRating;
    }
}
