package org.itmo.mega.moviemanager.repository;

import org.itmo.mega.moviemanager.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
