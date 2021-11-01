package ddeliopoulos.github.gardenjournal.journalentry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface JournalRepository extends JpaRepository<JournalEntry, Long> {

//    List<JournalEntry> findAllByTypeAnd...

    void deleteAllByPlantId(Long plantId);

//     @Query("select entry from JournalEntry entry where entry.type LIKE '%?1%' order by entry.createdAt desc") // HQL
//    @Query(value = "select * from journal_entries where type = magic(?1) order by created_at desc", nativeQuery = true) // native
    List<JournalEntry> findAllByTypeIgnoreCaseContainingAndPlantIdOrderByCreatedAtDesc(final String type, final long plantId);
}




