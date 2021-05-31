package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class CreatePlantRequest {

    private final String name;
    private final int colorRed;
    private final int colorGreen;
    private final int colorBlue;
    private final Integer heightInInches;

}
