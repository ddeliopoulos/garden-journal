package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public final class CreatePlantRequest {

    @NotBlank(message = "Name is mandatory")
    private final String name;
    private final int colorRed;
    private final int colorGreen;
    private final int colorBlue;
    private final Integer heightInInches;

}
