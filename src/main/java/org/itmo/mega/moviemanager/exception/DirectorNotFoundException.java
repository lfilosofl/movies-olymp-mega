package org.itmo.mega.moviemanager.exception;

public class DirectorNotFoundException extends RuntimeException {

    public DirectorNotFoundException(Long id) {
        super("Unable to find director with id = " + id);
    }
}
