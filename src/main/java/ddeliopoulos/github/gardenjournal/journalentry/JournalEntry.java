package ddeliopoulos.github.gardenjournal.journalentry;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
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

    public JournalEntry updateWith(InsertJournalRequest journalEntryRequest) {
        return new JournalEntry(
                this.id,
                journalEntryRequest.getText(),
                journalEntryRequest.getImage(),
                journalEntryRequest.getAudio()
        );
    }

}
