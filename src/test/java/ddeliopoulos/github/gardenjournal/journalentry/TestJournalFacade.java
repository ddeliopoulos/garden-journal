package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponseBody;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestJournalFacade {

    private final JournalService journalService;

    public Long createNewJournalEntry(final InsertJournalRequestBody request, Long plantId) {
        return journalService.createNewJournalEntry(request, plantId);
    }

    public GetJournalResponseBody getJournalEntry(Long journalEntryId) {
        return journalService.getJournalEntry(journalEntryId);
    }

}
