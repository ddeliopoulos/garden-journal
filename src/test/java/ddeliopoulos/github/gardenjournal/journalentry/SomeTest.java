package ddeliopoulos.github.gardenjournal.journalentry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class SomeTest {

    static class SomeRepository {
        String getNameById(Long id) {
            return "eyyy" + id;
        }
        void bla(Object eyy) {

        }
    }

    private final SomeRepository mockRepository = mock(SomeRepository.class);

    @Test
    void someTestCase() {
        // given:
        when(mockRepository.getNameById(anyLong())).thenReturn("123");

        // when:
        System.out.println(mockRepository.getNameById(123L));
        System.out.println(mockRepository.getNameById(12345L));

        String result = mockRepository.getNameById(666L);

        // then:
        Assertions.assertEquals("123", result);
        verify(mockRepository, times(3)).getNameById(anyLong());
    }

}
