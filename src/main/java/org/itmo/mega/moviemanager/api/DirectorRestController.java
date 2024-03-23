package org.itmo.mega.moviemanager.api;

import jakarta.validation.Valid;
import org.itmo.mega.moviemanager.dto.DirectorDto;
import org.itmo.mega.moviemanager.dto.DirectorListDto;
import org.itmo.mega.moviemanager.service.DirectorService;
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
@RequestMapping("/api/directors")
public class DirectorRestController {

    private final DirectorService directorService;

    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public DirectorListDto getDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("{id}")
    public DirectorDto getDirector(@PathVariable Long id) {
        return directorService.getDirector(id);
    }

    @PostMapping
    public DirectorDto addDirector(@RequestBody @Valid DirectorDto director) {
        return directorService.addDirector(director);
    }

    @PatchMapping("{id}")
    public DirectorDto updateDirector(@PathVariable Long id, @RequestBody @Valid DirectorDto director) {
        return directorService.updateDirector(id, director);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeDirector(@PathVariable Long id) {
        directorService.removeDirector(id);
    }
}
