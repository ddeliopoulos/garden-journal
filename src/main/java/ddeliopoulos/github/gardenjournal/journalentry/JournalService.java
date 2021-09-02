package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import ddeliopoulos.github.gardenjournal.media.MediaFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
class JournalService {

    private final MediaFacade mediaFacade;
    private final JournalRepository journalRepository;

    List<GetJournalResponse> getJournalEntries() {
        return journalRepository.findAll()
                .stream()
                .map(this::mapEntityToGetResponse)
                .collect(Collectors.toList());
    }

    Long createNewJournalEntry(final InsertJournalRequest request) {
        final Long mediaId = mediaFacade.createNewMedia(request.getData());
        final JournalEntry entity = new JournalEntry(
                null,
                request.getCreatedAt(),
                request.getType(),
                mediaId
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
                nullableJournalEntry.getCreatedAt(),
                nullableJournalEntry.getType(),
                nullableJournalEntry.getData()
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

