package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class GetPlantResponse {

    private final Long id;
    private final String name;
    private final String type;
    private final String date;
}
