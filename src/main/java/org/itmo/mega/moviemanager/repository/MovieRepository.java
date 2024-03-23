package org.itmo.mega.moviemanager.repository;

import org.itmo.mega.moviemanager.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
