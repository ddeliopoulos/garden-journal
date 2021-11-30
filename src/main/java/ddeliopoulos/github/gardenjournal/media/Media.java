package ddeliopoulos.github.gardenjournal.media;

import lombok.*;
import org.hibernate.annotations.Type;

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
    @Type(type="org.hibernate.type.BinaryType")
    @Column
    private byte[] data;
    private String contentType;
}
