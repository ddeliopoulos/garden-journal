package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.CreateJournalRequest;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    JournalService(final JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    List<GetJournalResponse> getJournalEntries() {
        final List<JournalEntry> allJournalEntries = journalRepository.findAll();

        final List<GetJournalResponse> allJournalEntriesMapped = new ArrayList<>(allJournalEntries.size());
        for (JournalEntry journalEntry : allJournalEntries) {
            final GetJournalResponse mappedJournalEntry = mapEntityToGetResponse(journalEntry);
            allJournalEntriesMapped.add(mappedJournalEntry);
        }
        return allJournalEntriesMapped;
    }

    Long createNewJournalEntry(final CreateJournalRequest request) {
        // create Journal entry entity
        final JournalEntry entity = new JournalEntry(
                null,
                request.getJournalEntryText(),
                request.getJournalEntryImage(),
                request.getJournalEntryAudio()
        );

        // save to database and get wrapped entity
        final JournalEntry savedEntity = journalRepository.save(entity);

        // return ID
        return savedEntity.getId();
    }

    GetJournalResponse getJournalEntries(Long journalEnryId) {
        return journalRepository.findById(journalEnryId)
                .map(this::mapEntityToGetResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                ));
    }

    private GetJournalResponse mapEntityToGetResponse(JournalEntry nullableJournalEntry) {
        return new GetJournalResponse(
                nullableJournalEntry.getJournalEntryText(),
                nullableJournalEntry.getJournalEntryImage(),
                nullableJournalEntry.getJournalEntryAudio()
        );
    }

    void removeJournalEntry(Long Id) {
        if (journalRepository.existsById(Id)) {
            journalRepository.deleteById(Id);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
