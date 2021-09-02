package ddeliopoulos.github.gardenjournal.plant;


import ddeliopoulos.github.gardenjournal.plant.api.CreatePlantRequest;
import ddeliopoulos.github.gardenjournal.plant.api.GetPlantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/plants")
class PlantController {

    private final PlantService plantService;

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
    public Long createNewPlant(@Valid @RequestBody CreatePlantRequest request) {
        // return ID from controller, user will receive as response
        return plantService.createNewPlant(request);
    }

    @DeleteMapping("/{plantId}")
    public void deletePlant(@PathVariable Long plantId){
        plantService.removePlant(plantId);
    }

}
