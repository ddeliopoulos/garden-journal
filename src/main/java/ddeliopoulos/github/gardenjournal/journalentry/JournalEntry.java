package ddeliopoulos.github.gardenjournal.journalentry;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private Long plantId;
    private Long createdAt;
    private String type;
    private Long mediaId;

}
