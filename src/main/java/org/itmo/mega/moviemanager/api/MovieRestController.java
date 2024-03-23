package org.itmo.mega.moviemanager.api;

import jakarta.validation.Valid;
import org.itmo.mega.moviemanager.dto.MovieDto;
import org.itmo.mega.moviemanager.dto.MovieListDto;
import org.itmo.mega.moviemanager.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public MovieListDto getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public MovieDto getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public MovieDto addMovie(@RequestBody @Valid MovieDto movie) {
        return movieService.addMovie(movie);
    }

    @PatchMapping("{id}")
    public MovieDto updateMovie(@PathVariable Long id, @RequestBody MovieDto movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeMovie(@PathVariable Long id) {
        movieService.removeMovie(id);
    }
}
