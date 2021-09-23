package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.journalentry.TestJournalFacade;
import ddeliopoulos.github.gardenjournal.journalentry.api.InsertJournalRequestBody;
import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequestBody;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PlantServiceIntegrationTest {

    @Autowired
    private PlantService plantService;

    @Autowired
    private TestJournalFacade journalFacade;

    @Test
    void createNewPlant_shouldCreateAPlant_thatIsThenAccessibleWithGetPlant() {
        // given:
        final CreatePlantRequestBody createPlantRequest = new CreatePlantRequestBody(
                "test name",
                "test type",
                123L
        );

        // when:
        final Long newPlantId = plantService.createNewPlant(createPlantRequest);
        final GetPlantResponseBody plant = plantService.getPlant(newPlantId);

        // then:
        assertEquals(newPlantId, plant.getId());
        assertEquals(createPlantRequest.getName(), plant.getName());
        assertEquals(createPlantRequest.getType(), plant.getType());
        assertEquals(createPlantRequest.getCreatedAt(), plant.getCreatedAt());
    }

    @Test
    @Transactional
        // create a new DB transaction so we can remove stuff
    void givenExistingPlant_whenItsDeleted_allJournalEntriesGetDeleted() {
        // given:
        final CreatePlantRequestBody createPlantRequest = new CreatePlantRequestBody(
                "test name",
                "test type",
                123L
        );
        final InsertJournalRequestBody insertJournalRequestBody = new InsertJournalRequestBody(

                123L,
                "SDFGSDSDFSDF",
                "Image"
        );

        final Long newPlantId = plantService.createNewPlant(createPlantRequest);
        final Long newJournalId = journalFacade.createNewJournalEntry(insertJournalRequestBody, newPlantId);

        // when:
        plantService.removePlant(newPlantId);

        // then:
        assertThrows(ResponseStatusException.class, () ->
                plantService.getPlant(newPlantId)
        );

        assertThrows(ResponseStatusException.class, () ->
                journalFacade.getJournalEntry(newJournalId)
        );
    }
}