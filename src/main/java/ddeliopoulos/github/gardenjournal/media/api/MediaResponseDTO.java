package ddeliopoulos.github.gardenjournal.media.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class MediaResponseDTO {

    private final String data;
    private final String contentType;

}


