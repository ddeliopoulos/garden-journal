package ddeliopoulos.github.gardenjournal.plant;
import ddeliopoulos.github.gardenjournal.journalentry.JournalFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlantFacade {

    private final PlantService plantService;
    private final JournalFacade journalFacade;

    public String checkEmailFromPlant(Long plantId){

        return plantService.getPlant(plantId).getUserEmail();

    }


}
