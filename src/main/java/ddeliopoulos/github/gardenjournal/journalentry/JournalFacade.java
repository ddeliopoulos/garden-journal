package ddeliopoulos.github.gardenjournal.journalentry;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JournalFacade {

    private final JournalService journalService;

    public void deleteAllJournalEntries(Long plantId) {
        journalService.removeAllJournalEntries(plantId);
    }

}
