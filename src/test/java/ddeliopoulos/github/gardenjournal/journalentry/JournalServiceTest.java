package ddeliopoulos.github.gardenjournal.journalentry;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collections;


class JournalServiceTest {


    private final JournalRepository mockJournalRepository = Mockito.mock(JournalRepository.class);

    //private final JournalService journalService = new JournalService(mockJournalRepository);

    @Test
    void getJournalEntries_whenRepositoryReturnsEmptyList_thenJournalServiceReturnsEmptyList() {

        Mockito.when(mockJournalRepository.findAll()).thenReturn(Collections.emptyList());

        //List<GetJournalResponse> journalEntries = journalService.getJournalEntries();

        //Assertions.assertTrue(journalEntries.isEmpty());

    }
}