package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JournalServiceTest {

    private final JournalRepository mockJournalRepository = Mockito.mock(JournalRepository.class);

    private final JournalService journalService = new JournalService(
            mockJournalRepository
    );

    @Test
    void getJournalEntries_whenRepositoryReturnsEmptyList_thenJournalServiceReturnsEmptyList(){

        Mockito.when(mockJournalRepository.findAll()).thenReturn(Collections.emptyList());

        List<GetJournalResponse> journalEntries = journalService.getJournalEntries();

        Assertions.assertTrue(journalEntries.isEmpty());

    }
}