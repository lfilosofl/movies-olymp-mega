package org.itmo.mega.moviemanager.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.itmo.mega.moviemanager.model.Director;

public class DirectorDto {

    @Valid
    @NotNull(message = "Field 'director' is required")
    private Director director;

    public DirectorDto() {
    }

    public DirectorDto(Director director) {
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
