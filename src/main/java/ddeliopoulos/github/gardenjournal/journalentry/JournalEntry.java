package ddeliopoulos.github.gardenjournal.journalentry;

import lombok.*;

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
    private Long createdAt;
    private String type;
    @Lob
    @Column(columnDefinition = "BLOB")
    private String data;

}
