package org.itmo.mega.moviemanager.service;

import jakarta.transaction.Transactional;
import org.itmo.mega.moviemanager.dto.MovieDto;
import org.itmo.mega.moviemanager.dto.MovieListDto;
import org.itmo.mega.moviemanager.exception.DirectorNotFoundException;
import org.itmo.mega.moviemanager.exception.MovieNotFoundException;
import org.itmo.mega.moviemanager.model.Director;
import org.itmo.mega.moviemanager.model.Movie;
import org.itmo.mega.moviemanager.repository.DirectorRepository;
import org.itmo.mega.moviemanager.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public MovieListDto getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        MovieListDto movieListDto = new MovieListDto(movies);
        return movieListDto;
    }

    public MovieDto getMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }
        return new MovieDto(movie.get());
    }

    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = movieDto.getMovie();
        movie.setId(null);
        Director director = movie.getDirector();
        Long directorId = director.getId();
        Optional<Director> existingDirector = directorRepository.findById(directorId);
        if (existingDirector.isEmpty()) {
            throw new DirectorNotFoundException(directorId);
        }
        movie.setDirector(existingDirector.get());
        movie = movieRepository.save(movie);
        return new MovieDto(movie);
    }

    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie movie = movieDto.getMovie();
        movie.setId(id);
        Optional<Movie> foundMovie = movieRepository.findById(id);
        if (foundMovie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }
        movie = movieRepository.save(movie);
        return new MovieDto(movie);
    }

    public void removeMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isEmpty()) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
    }
}
