package ddeliopoulos.github.gardenjournal.test;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor

class TestAPI {
    private final TestService service;

    @GetMapping("/hello")
    // capture reqeuest to localhost:8080/hello
    public String hello(@Param("id") final Long id /* capture query param like ?id=5 */) {
        if (id == null) return "you need to provide an ID dum dum";
        return "Hey, nice to see ya " + service.getName(id) + "!";
    }


}
