package ddeliopoulos.github.gardenjournal.plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class PlantFacade {

    private final PlantService plantService;

    @Autowired
    public PlantFacade(@Lazy PlantService plantService) {
        this.plantService = plantService;
    }

    public String checkEmailFromPlant(Long plantId){

        return plantService.getPlant(plantId).getUserEmail();

    }


}
