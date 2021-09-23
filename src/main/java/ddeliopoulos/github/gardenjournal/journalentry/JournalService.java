package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequestBody;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponseBody;
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

    List<GetJournalResponseBody> getJournalEntries() {
        return journalRepository.findAll()
                                .stream()
                                .map(this::mapEntityToGetResponse)
                                .collect(Collectors.toList());
    }

    Long createNewJournalEntry(final InsertJournalRequestBody request, Long plantId) {
        final Long mediaId = mediaFacade.createNewMedia(request.getData(), request.getType());
        final JournalEntry entity = new JournalEntry(
                null,
                plantId,
                request.getCreatedAt(),
                request.getType(),
                mediaId
        );

        final JournalEntry savedEntity = journalRepository.save(entity);

        return savedEntity.getId();
    }

    GetJournalResponseBody getJournalEntry(Long journalEntryId) {
        return journalRepository.findById(journalEntryId)
                                .map(this::mapEntityToGetResponse)
                                .orElseThrow(() -> new ResponseStatusException(
                                        HttpStatus.NOT_FOUND, "entity not found"
                                ));
    }

    private GetJournalResponseBody mapEntityToGetResponse(JournalEntry nullableJournalEntry) {
        return new GetJournalResponseBody(
                nullableJournalEntry.getCreatedAt(),
                nullableJournalEntry.getType(),
                nullableJournalEntry.getMediaId()
        );
    }

    void removeJournalEntry(Long Id) {
        if (journalRepository.existsById(Id)) {
            journalRepository.deleteById(Id);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    void removeAllJournalEntries(Long plantId) {
        journalRepository.deleteAllByPlantId(plantId);
    }
}

