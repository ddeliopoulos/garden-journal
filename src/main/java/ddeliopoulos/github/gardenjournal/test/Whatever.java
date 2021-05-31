package ddeliopoulos.github.gardenjournal.test;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Whatever {

    @OneToMany
    private List<Test> items;

    @Id
    private Long id;
}
