package org.itmo.mega.moviemanager.api;

import org.itmo.mega.moviemanager.dto.DirectorDto;
import org.itmo.mega.moviemanager.dto.DirectorListDto;
import org.itmo.mega.moviemanager.model.Director;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DirectorRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void directorShouldBeCreatedWithSpecifiedFIO() throws Exception {
        Director resultDirector = addDirector("Ivanov");
        DirectorDto foundDirector = restTemplate.getForObject("http://localhost:" + port + "/api/directors/" + resultDirector.getId(), DirectorDto.class);
        assertEquals("Ivanov", foundDirector.getDirector().getFio());
    }

    private Director addDirector(String fio) {
        Director director = new Director();
        director.setFio(fio);
        DirectorDto body = new DirectorDto(director);
        DirectorDto result = restTemplate.postForObject("http://localhost:" + port + "/api/directors", body, DirectorDto.class);
        return result.getDirector();
    }

    @Test
    void directorShouldBeRemoved() {
        Director director = addDirector("Test Director");
        DirectorListDto directorList = restTemplate.getForObject("http://localhost:" + port + "/api/directors", DirectorListDto.class);
        List<Director> directors = directorList.getList();
        assertEquals(1, directors.size());
        restTemplate.delete("http://localhost:" + port + "/api/directors/" + director.getId());

        directorList = restTemplate.getForObject("http://localhost:" + port + "/api/directors", DirectorListDto.class);
        directors = directorList.getList();
        assertEquals(0, directors.size());

    }

    @Test
    void fioShouldCheckedForPresence() {
        DirectorDto body = new DirectorDto(new Director());
        ResponseEntity<?> result = restTemplate.postForEntity("http://localhost:" + port + "/api/directors", body, Map.class);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }
}
