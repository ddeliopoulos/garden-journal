package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponseBody;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequestBody;
import ddeliopoulos.github.gardenjournal.plant.PlantFacade;
import ddeliopoulos.github.gardenjournal.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
class JournalService {

    private final JournalRepository journalRepository;
    private final UserService userService;
    private final PlantFacade plantFacade;

    List<GetJournalResponseBody> getJournalEntries(final String type, final long plantId) {
        // TODO: if plant does not belong to user, throw exception
        verifyPlantOwner(plantId);
//        return journalRepository.findAllByTypeIgnoreCaseContainingAndPlantIdOrderByCreatedAtDescAndUserEmail(type, plantId, userService.getUserEmail())
        return journalRepository.findAllByTypeIgnoreCaseContainingAndPlantIdOrderByCreatedAtDesc(type, plantId)
                                .stream()
                                .map(this::mapEntityToGetResponse)
                                .collect(Collectors.toList());
    }

    void verifyPlantOwner(Long plantId) {
        if (!plantFacade.checkEmailFromPlant(plantId)
                        .equals(userService.getUserEmail())) {
            throw new AccessDeniedException("You do not have access!");
        }
    }


    Long createNewJournalEntry(final InsertJournalRequestBody request, Long plantId) {
        verifyPlantOwner(plantId);
        final JournalEntry entity = new JournalEntry(
                null,
                plantId,
                request.getCreatedAt(),
                request.getType(),
                request.getMediaId()
        );

        final JournalEntry savedEntity = journalRepository.save(entity);

        return savedEntity.getId();
    }

    GetJournalResponseBody getJournalEntry(Long journalEntryId) {

        Long plantId = Objects.requireNonNull(journalRepository.findById(journalEntryId)
                                                               .orElse(null))
                              .getPlantId();
        verifyPlantOwner(plantId);

        return journalRepository.findById(journalEntryId)
                                .map(this::mapEntityToGetResponse)
                                .orElseThrow(() -> new ResponseStatusException(
                                        HttpStatus.NOT_FOUND, "entity not found"
                                ));
    }

    private GetJournalResponseBody mapEntityToGetResponse(JournalEntry nullableJournalEntry) {
        return new GetJournalResponseBody(
                nullableJournalEntry.getId(),
                nullableJournalEntry.getCreatedAt(),
                nullableJournalEntry.getType(),
                nullableJournalEntry.getMediaId()
        );
    }

    void removeJournalEntry(Long plantId) {
        verifyPlantOwner(plantId);
        if (journalRepository.existsById(plantId)) {
            journalRepository.deleteById(plantId);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    void removeAllJournalEntries(Long plantId) {
        verifyPlantOwner(plantId);
        journalRepository.deleteAllByPlantId(plantId);
    }
}

