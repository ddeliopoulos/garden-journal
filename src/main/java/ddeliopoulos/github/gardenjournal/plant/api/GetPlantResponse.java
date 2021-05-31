package ddeliopoulos.github.gardenjournal.plant.api;

import ddeliopoulos.github.gardenjournal.plant.PlantColor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class GetPlantResponse {

    private final Long id;
    private final String name;
    private final PlantColor color;
    private final Integer heightInInches;

}
