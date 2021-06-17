package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public final class CreatePlantRequest {

    @NotBlank(message = "Name is mandatory")
    private final String name;
    private final String Type;
}
