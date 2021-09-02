package ddeliopoulos.github.gardenjournal.media;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
class Media {
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    @Column(columnDefinition = "BLOB")
    private String data;
}
