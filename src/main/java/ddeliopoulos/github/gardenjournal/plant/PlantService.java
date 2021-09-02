package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequest;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * no visibility specified, so it's package-private (only visible in package)
 */
@Service
@RequiredArgsConstructor
class PlantService {

    private final PlantRepository plantRepository;

    List<GetPlantResponse> getPlants() {
        final List<Plant> allPlants = plantRepository.findAll();

        final List<GetPlantResponse> allPlantsMapped = new ArrayList<>(allPlants.size());
        for (Plant plant : allPlants) {
            final GetPlantResponse mappedPlant = mapEntityToGetResponse(plant);
            allPlantsMapped.add(mappedPlant);
        }
        return allPlantsMapped;
    }

    Long createNewPlant(final CreatePlantRequest request) {
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

    GetPlantResponse getPlant(Long plantId) {
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

    private GetPlantResponse mapEntityToGetResponse(Plant nullablePlant) {
        return new GetPlantResponse(
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
