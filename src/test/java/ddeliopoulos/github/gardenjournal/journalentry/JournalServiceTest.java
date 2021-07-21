package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.Request;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssumptions.given;

class JournalServiceTest {

    @Mock
    private final JournalRepository mockJournalRepository;

    @InjectMocks
    private final JournalService journalService;

    JournalServiceTest(JournalRepository mockJournalRepository, JournalService journalService) {
        this.mockJournalRepository = mockJournalRepository;
        this.journalService = journalService;
    }


    //private final JournalRepository mockJournalRepository = Mockito.mock(JournalRepository.class);

//    private final JournalService journalService = new JournalService(
//            mockJournalRepository
//    );

    @Test
    void getJournalEntries_whenRepositoryReturnsEmptyList_thenJournalServiceReturnsEmptyList(){

        Mockito.when(mockJournalRepository.findAll()).thenReturn(Collections.emptyList());

        List<GetJournalResponse> journalEntries = journalService.getJournalEntries();

        Assertions.assertTrue(journalEntries.isEmpty());

    }

    //when there is no such entity in database, throw exception
    @Test
    void updateJournal_whenThereIsNoSuchEntityInDatabase_ThrowException() {
        //How do I know/make this mock repository empty?
        final JournalEntry journalEntry = new JournalEntry(1L, "adasda","Adasda","asdada");

        List<GetJournalResponse> journalEntries = journalService.getJournalEntries();

        Mockito.when(mockJournalRepository.findById(journalEntry.getId())).thenThrow(ResponseStatusException.class);

        //then
        Assertions.assertThrows(ResponseStatusException.class, ()->{

        });





    }
}