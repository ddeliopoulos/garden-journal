package ddeliopoulos.github.gardenjournal.plant;

import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequest;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        final Plant nullablePlant = plantRepository.getById(plantId);
        if (nullablePlant != null) {
            return mapEntityToGetResponse(nullablePlant);
        } else {
            return null;
        }

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

}
