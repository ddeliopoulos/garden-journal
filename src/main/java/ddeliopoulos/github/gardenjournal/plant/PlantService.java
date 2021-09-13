package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequestBody;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponseBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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

    List<GetPlantResponseBody> getPlants() {
        final List<Plant> allPlants = plantRepository.findAll();

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
                request.getCreatedAt()
        );

        // save to database and get wrapped entity
        final Plant savedEntity = plantRepository.save(entity);

        // return ID
        return savedEntity.getId();
    }

    GetPlantResponseBody getPlant(Long plantId) {
        //        final Optional<Plant> nullablePlant = plantRepository.findById(plantId);
//
//        if (nullablePlant.isPresent()) {
//            return mapEntityToGetResponse(nullablePlant.get());
//        } else
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "entity not found"
//            );

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
                nullablePlant.getCreatedAt()

        );
    }
    void removePlant(Long Id){
        if(plantRepository.existsById(Id)) {
            plantRepository.deleteById(Id);
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
}
