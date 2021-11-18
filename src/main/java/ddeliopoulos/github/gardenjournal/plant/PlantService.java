package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.journalentry.JournalFacade;
import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequestBody;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponseBody;
import ddeliopoulos.github.gardenjournal.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * no visibility specified, so it's package-private (only visible in package)
 */

@Slf4j
@Service
@RequiredArgsConstructor
class PlantService {

    private final PlantRepository plantRepository;
    private final JournalFacade journalFacade;
    private final UserService userService;

    List<GetPlantResponseBody> getPlants() {

        final List<Plant> allPlants = plantRepository.findAllByUserEmail(userService.getUserEmail());
        final List<GetPlantResponseBody> allPlantsMapped = new ArrayList<>(allPlants.size());

        for (Plant plant : allPlants) {
            final GetPlantResponseBody mappedPlant = mapEntityToGetResponse(plant);
            allPlantsMapped.add(mappedPlant);
        }
        return allPlantsMapped;
    }

    Long createNewPlant(final CreatePlantRequestBody request) {

        log.info("creating a plant! {}", request);
        // create Plant entity
        final Plant entity = new Plant(
                null,
                request.getName(),
                request.getType(),
                request.getCreatedAt(),
                userService.getUserEmail()
        );
        // save to database and get wrapped entity
        final Plant savedEntity = plantRepository.save(entity);

        // return ID
        journalFacade.verifyPlantOwner(savedEntity.getId());

        return savedEntity.getId();
    }

    GetPlantResponseBody getPlant(Long plantId) {
        journalFacade.verifyPlantOwner(plantId);
        return plantRepository.findById(plantId)
                              .map(this::mapEntityToGetResponse)
                              .orElseThrow(() -> new ResponseStatusException(
                                      HttpStatus.NOT_FOUND, "entity not found"
                              ));
    }

    private GetPlantResponseBody mapEntityToGetResponse(Plant nullablePlant) {
        return new GetPlantResponseBody(
                nullablePlant.getId(),
                nullablePlant.getName(),
                nullablePlant.getType(),
                nullablePlant.getCreatedAt(),
                nullablePlant.getUserEmail()
        );
    }

    void removePlant(Long plantId) {
        journalFacade.verifyPlantOwner(plantId);
        if (plantRepository.existsById(plantId)) {
            plantRepository.deleteById(plantId);
            journalFacade.deleteAllJournalEntries(plantId);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
