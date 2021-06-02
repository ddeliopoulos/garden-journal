package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequest;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * no visibility specified so it's package-private (only visible in package)
 */
@Service
class PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    PlantService(final PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

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
                new PlantColor(
                        request.getColorRed(),
                        request.getColorGreen(),
                        request.getColorBlue()
                ),
                request.getHeightInInches()
        );

        // save to database and get wrapped entity
        final Plant savedEntity = plantRepository.save(entity);

        // return ID
        return savedEntity.getId();
    }

    GetPlantResponse getPlant(Long plantId) {
        final Optional<Plant> nullablePlant = plantRepository.findById(plantId);
        if (nullablePlant.isPresent()) {
            return mapEntityToGetResponse(nullablePlant.get());
        } else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );


//        final Optional<Plant> optionalPlant = plantRepository.findById(plantId);

    }

    private GetPlantResponse mapEntityToGetResponse(Plant nullablePlant) {
        return new GetPlantResponse(
                nullablePlant.getId(),
                nullablePlant.getName(),
                nullablePlant.getColor(),
                nullablePlant.getHeightInInches()
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
