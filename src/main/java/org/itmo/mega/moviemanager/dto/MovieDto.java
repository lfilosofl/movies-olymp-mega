package org.itmo.mega.moviemanager.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.itmo.mega.moviemanager.model.Movie;

public class MovieDto {

    @Valid
    @NotNull(message = "Field 'movie' is required")
    private Movie movie;

    public MovieDto() {
    }

    public MovieDto(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
