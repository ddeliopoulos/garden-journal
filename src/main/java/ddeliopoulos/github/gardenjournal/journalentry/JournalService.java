package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
class JournalService {

    private final JournalRepository journalRepository;

    List<GetJournalResponse> getJournalEntries() {
        return journalRepository.findAll()
                .stream()
                .map(this::mapEntityToGetResponse)
                .collect(Collectors.toList());
    }

    Long createNewJournalEntry(final InsertJournalRequest request) {
        final JournalEntry entity = new JournalEntry(
                null,
                request.getText(),
                request.getImage(),
                request.getAudio()
        );

        final JournalEntry savedEntity = journalRepository.save(entity);

        return savedEntity.getId();
    }

    GetJournalResponse getJournalEntries(Long journalEntryId) {
        return journalRepository.findById(journalEntryId)
                .map(this::mapEntityToGetResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                ));
    }

    private GetJournalResponse mapEntityToGetResponse(JournalEntry nullableJournalEntry) {
        return new GetJournalResponse(
                nullableJournalEntry.getText(),
                nullableJournalEntry.getImage(),
                nullableJournalEntry.getAudio()
        );
    }

    void removeJournalEntry(Long Id) {
        if (journalRepository.existsById(Id)) {
            journalRepository.deleteById(Id);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    // when there is no such entity in database, throw exception
    // when entity exists then the updated entity is saved to the database
    void updateJournal(Long Id, InsertJournalRequest newJournalEntryRequest) {

        final JournalEntry JournalEntry = journalRepository.findById(Id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no entity found")
                );
        JournalEntry.setText(newJournalEntryRequest.getText());
        JournalEntry.setAudio(newJournalEntryRequest.getAudio());
        JournalEntry.setImage(newJournalEntryRequest.getImage());

        journalRepository.save(JournalEntry);
    }
}



