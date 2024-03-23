package org.itmo.mega.moviemanager.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Unable to find movie with id = " + id);
    }
}
