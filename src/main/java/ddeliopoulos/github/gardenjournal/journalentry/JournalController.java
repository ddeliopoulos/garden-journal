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

    @GetMapping("/plants/{plantId}/journal-entries")
    public List<GetJournalResponseBody> getJournalEntry(@RequestParam(value = "type", defaultValue = "") final String type, @PathVariable final long plantId) { // TODO: add filtering by type and other query params
        return journalService.getJournalEntries(type, plantId);
    }

    @GetMapping("/journal-entries/{journalEntryId}")
    public GetJournalResponseBody getJournalEntryById(@PathVariable Long journalEntryId) {
        return journalService.getJournalEntry(journalEntryId);
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


    @DeleteMapping("/plants/{plantId}/journal-entries")
    public void deleteAllJournalEntries(@PathVariable Long plantId) {
        journalService.removeAllJournalEntries(plantId);
    }


}
