package ddeliopoulos.github.gardenjournal.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlantFacade {

    private final PlantService plantService;

    public String checkEmailFromPlant(Long plantId) {
        return plantService.getPlant(plantId)
                           .getUserEmail();
    }


}
