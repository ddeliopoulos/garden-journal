package ddeliopoulos.github.gardenjournal.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

// generate table `tests`
// hibernate - library responsible for mapping this
@Entity
public class TestOld {

    @Id
    // primary key with name `id`
    private Long id;

    // db column with name `name`
    private String name;

    private Date createdAt = new Date();

    protected TestOld() {
    }

    public TestOld(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
