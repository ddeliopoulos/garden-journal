package ddeliopoulos.github.gardenjournal.test;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

// lombok party!
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {

    @Id
    private Long id;
    private String name;
    private Date createdAt = new Date();

}
