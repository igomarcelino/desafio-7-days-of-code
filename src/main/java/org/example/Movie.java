package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private String title;
    private String urlImage;
    private Double rating;
    private Integer year;

    public Movie() {
    }

    public Movie(String title, String urlImage, Double rating, Integer year) {
        this.title = title;
        this.urlImage = urlImage;
        this.rating = rating;
        this.year = year;
    }

    public Movie(MoviesFromAPI movie) {
        this.title = movie.getTitle();
        this.urlImage = movie.getBackdropPath();
        this.rating = movie.getVoteAverage();
        this.year = Integer.valueOf(movie.getReleaseDate().substring(0,4));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) && Objects.equals(year, movie.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }


    @Override
    public int compareTo(@NotNull Movie o) {
        return title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", rating=" + rating +
                ", year=" + year +
                '}';
    }
}
