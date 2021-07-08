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
public class JournalEntry {
    @Id
    @GeneratedValue
    private Long id;
    private String journalEntryText;
    @Lob
    @Column(columnDefinition="BLOB")
    private String journalEntryImage;
    @Lob
    @Column(columnDefinition="BLOB")
    private String journalEntryAudio;

}
