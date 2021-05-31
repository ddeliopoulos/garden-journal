package ddeliopoulos.github.gardenjournal.raidedbed;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class RaisedBed {

    @Id
    private Long id;
    private String name;
    private Integer height;
    private Integer length;
    private Integer width;


}
