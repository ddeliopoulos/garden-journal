package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/journal-entries")
class JournalController {

    private final JournalService journalService;

    @GetMapping
    public List<GetJournalResponse> getJournalEntry() {
        return journalService.getJournalEntries();
    }

    @GetMapping("/{journalEntryId}")
    public GetJournalResponse getJournalEntryById(@PathVariable Long journalEntryId) {
        return journalService.getJournalEntries(journalEntryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createNewJournalEntry(@Valid @RequestBody InsertJournalRequest request) {
        return journalService.createNewJournalEntry(request);
    }

    @DeleteMapping("/{journalEntryId}")
    public void deleteJournalEntry(@PathVariable Long journalEntryId) {
        journalService.removeJournalEntry(journalEntryId);
    }

}
