package ddeliopoulos.github.gardenjournal.journalentry;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString

public class JournalEntryQuery {
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
