package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@RequiredArgsConstructor
public final class CreatePlantRequestBody {

    @NotBlank(message = "Name is mandatory")
    private final String name;
    @NotBlank
    private final String type;
    @NotNull
    private final Long createdAt;
}
