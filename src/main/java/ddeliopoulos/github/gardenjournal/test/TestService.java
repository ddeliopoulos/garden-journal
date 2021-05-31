package ddeliopoulos.github.gardenjournal.test;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
class TestService {

    private final TestRepository repository;

    TestService(final TestRepository repository) {
        this.repository = repository;
        repository.save(
                new Test(5L, "bla", new Date())
        );
    }

    String getName(final long id) {
        return repository.getById(id).getName();
    }

}
