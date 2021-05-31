package ddeliopoulos.github.gardenjournal.leaves;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class Leaves {
    @Id
    private Long id;
    private String color;
    private Integer numberOfLeaves;

}