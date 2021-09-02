package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public final class CreatePlantRequest {

    @NotBlank(message = "Name is mandatory")
    private final String name;
    @NotBlank
    private final String type;
    @NotNull
    private final Long createdAt;
}
