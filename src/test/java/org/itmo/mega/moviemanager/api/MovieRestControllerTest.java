package org.itmo.mega.moviemanager.api;

import org.itmo.mega.moviemanager.dto.MovieDto;
import org.itmo.mega.moviemanager.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MovieRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void titleShouldCheckedForPresence() {
        MovieDto body = new MovieDto(new Movie());
        ResponseEntity<?> result = restTemplate.postForEntity("http://localhost:" + port + "/api/movies", body, Map.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
}
