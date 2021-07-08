package ddeliopoulos.github.gardenjournal.journalentry;
import lombok.*;
import org.hibernate.type.descriptor.sql.LobTypeMappings;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
class JournalEntry {
    @Id
    @GeneratedValue
    private Long id;
    private String Text;
    @Lob
    @Column(columnDefinition="BLOB")
    private String Image;
    @Lob
    @Column(columnDefinition="BLOB")
    private String Audio;

}
