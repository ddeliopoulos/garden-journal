package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    // PUT https://localhost:8055/journal-entries/15
    @PutMapping("/{journalEntryId}")
    public ResponseEntity<Void> update(
            @PathVariable("journalEntryId") @Valid @Min(0) Long id,
            @RequestBody InsertJournalRequest updatedJournalEntry) {
        journalService.updateJournal(id, updatedJournalEntry);

        return ResponseEntity.noContent().build();
    }
}
