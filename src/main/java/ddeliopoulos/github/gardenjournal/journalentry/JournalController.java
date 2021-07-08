package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.CreateJournalRequest;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/journal-entries")
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

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
    public Long createNewJournalEntry(@Valid @RequestBody CreateJournalRequest request) {
        // return ID from controller, user will receive as response
        return journalService.createNewJournalEntry(request);
    }

    @DeleteMapping("/{journalEntryId}")
    public void deleteJournalEntry(@PathVariable Long journalEntryId) {
        journalService.removeJournalEntry(journalEntryId);
    }
}
