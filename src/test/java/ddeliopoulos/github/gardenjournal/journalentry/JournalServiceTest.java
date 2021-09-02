package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.journalentry.api.GetJournalResponse;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;


class JournalServiceTest {


    private final JournalRepository mockJournalRepository = Mockito.mock(JournalRepository.class);

    private final JournalService journalService = new JournalService(mockJournalRepository);

    @Test
    void getJournalEntries_whenRepositoryReturnsEmptyList_thenJournalServiceReturnsEmptyList() {

        Mockito.when(mockJournalRepository.findAll()).thenReturn(Collections.emptyList());

        List<GetJournalResponse> journalEntries = journalService.getJournalEntries();

        Assertions.assertTrue(journalEntries.isEmpty());

    }

    //when there is no such entity in database, throw exception
    @Test
    void updateJournal_whenThereIsNoSuchEntityInDatabase_ThrowException() {
        // given:
        Mockito.when(mockJournalRepository.findById(anyLong())).thenReturn(Optional.empty());
        final InsertJournalRequest journalRequest = new InsertJournalRequest("random", "shit", "bish");

        // then:
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            // when:
            journalService.updateJournal(1L, journalRequest);
        });
    }


    //        Mockito.when(mockJournalRepository.findById(journalEntry.getId())).thenReturn(Optional.of(journalEntry));
    @Test
    void updateJournal_whenRepositoryIsCrashed_ThrowException() {
        //How do I know/make this mock repository empty?

        // given
        final JournalEntry journalEntry = new JournalEntry(1L, "adasda", "Adasda", "asdada");

        // when
        Mockito.when(mockJournalRepository.findById(journalEntry.getId())).thenThrow(ResponseStatusException.class);


        // then
    }

    // when entity exists then the updated entity is saved to the database

    @Test
    void updateJournal_whenEntityExistsThenTheUpdatedEntityIsSavedToDatabase(){

        // given:
        final JournalEntry journalEntry = new JournalEntry(1L, "adasda", "Adasda", "asdada");
        BDDMockito.given(mockJournalRepository.findById(journalEntry.getId())).willReturn(Optional.of(journalEntry));
        final InsertJournalRequest journalRequest = new InsertJournalRequest("random", "shit", "bish");

        // when:
        journalService.updateJournal(1L, journalRequest);

        // then:
        ArgumentCaptor<JournalEntry> entryCaptor = ArgumentCaptor.forClass(JournalEntry.class);
        verify(mockJournalRepository).save(entryCaptor.capture());
        final JournalEntry savedEntity = entryCaptor.getValue();
        Assertions.assertEquals("random", savedEntity.getText());
        Assertions.assertEquals("shit", savedEntity.getImage());
        Assertions.assertEquals("bish", savedEntity.getAudio());

    }

}