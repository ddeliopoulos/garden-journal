package ddeliopoulos.github.gardenjournal.journalentry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JournalRepository extends JpaRepository<JournalEntry, Long> {

}



