package ddeliopoulos.github.gardenjournal.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public final class Color {

    private final int red;
    private final int green;
    private final int blue;

}
