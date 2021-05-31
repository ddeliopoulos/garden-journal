package ddeliopoulos.github.gardenjournal.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class UserAPI {
    private final UserService service;
}
