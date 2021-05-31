package ddeliopoulos.github.gardenjournal.plant;


import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequest;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/plants")
class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<GetPlantResponse> getPlants() {
        return plantService.getPlants();
    }

    @GetMapping("/{plantId}")
    public GetPlantResponse getPlantById(@PathVariable Long plantId) {
        return plantService.getPlant(plantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "*")
    public Long createNewPlant(@RequestBody CreatePlantRequest request) {
        // return ID from controller, user will receive as response
        return plantService.createNewPlant(request);
    }

}
