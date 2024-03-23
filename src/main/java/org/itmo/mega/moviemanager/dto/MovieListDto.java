package org.itmo.mega.moviemanager.dto;

import org.itmo.mega.moviemanager.model.Movie;

import java.util.List;

public class MovieListDto {

    private List<Movie> list;

    public MovieListDto() {
    }

    public MovieListDto(List<Movie> list) {
        this.list = list;
    }

    public List<Movie> getList() {
        return list;
    }

    public void setList(List<Movie> list) {
        this.list = list;
    }
}
