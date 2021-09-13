package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class GetPlantResponseBody {

    private final Long id;
    private final String name;
    private final String type;
    private final Long createdAt;

}
