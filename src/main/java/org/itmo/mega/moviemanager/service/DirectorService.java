package org.itmo.mega.moviemanager.service;

import jakarta.transaction.Transactional;
import org.itmo.mega.moviemanager.dto.DirectorDto;
import org.itmo.mega.moviemanager.dto.DirectorListDto;
import org.itmo.mega.moviemanager.exception.DirectorNotFoundException;
import org.itmo.mega.moviemanager.model.Director;
import org.itmo.mega.moviemanager.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public DirectorListDto getAllDirectors() {
        List<Director> directors = directorRepository.findAll();
        DirectorListDto directorListDto = new DirectorListDto(directors);
        return directorListDto;
    }

    public DirectorDto getDirector(Long id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isEmpty()) {
            throw new DirectorNotFoundException(id);
        }
        return new DirectorDto(director.get());
    }

    public DirectorDto addDirector(DirectorDto directorDto) {
        Director director = directorDto.getDirector();
        director.setId(null);
        director = directorRepository.save(director);
        return new DirectorDto(director);
    }

    public DirectorDto updateDirector(Long id, DirectorDto directorDto) {
        Director director = directorDto.getDirector();
        director.setId(id);
        Optional<Director> foundDirector = directorRepository.findById(id);
        if (foundDirector.isEmpty()) {
            throw new DirectorNotFoundException(id);
        }
        director = directorRepository.save(director);
        return new DirectorDto(director);
    }

    public void removeDirector(Long id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isEmpty()) {
            throw new DirectorNotFoundException(id);
        }
        directorRepository.deleteById(id);
    }
}
