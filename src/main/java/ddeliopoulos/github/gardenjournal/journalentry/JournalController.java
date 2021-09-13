package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponseBody;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
class JournalController {

    private final JournalService journalService;

    @GetMapping("/journal-entries")
    public List<GetJournalResponseBody> getJournalEntry() {
        return journalService.getJournalEntries();
    }

    @GetMapping("/journal-entries/{journalEntryId}")
    public GetJournalResponseBody getJournalEntryById(@PathVariable Long journalEntryId) {
        return journalService.getJournalEntries(journalEntryId);
    }

    @PostMapping("/plants/{plantId}/journal-entries")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createNewJournalEntry(@Valid @RequestBody InsertJournalRequestBody request, @PathVariable Long plantId) {
        return journalService.createNewJournalEntry(request, plantId);
    }

    @DeleteMapping("/journal-entries/{journalEntryId}")
    public void deleteJournalEntry(@PathVariable Long journalEntryId) {
        journalService.removeJournalEntry(journalEntryId);
    }

}
