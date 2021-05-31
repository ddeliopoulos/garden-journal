package ddeliopoulos.github.gardenjournal.user;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class User {
    @Id
    private Long id;
    private String email;
    private String password;

}