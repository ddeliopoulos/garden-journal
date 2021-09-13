package ddeliopoulos.github.gardenjournal.media;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
@RequiredArgsConstructor
public class MediaFacade {

    private final MediaService mediaService;

    public Long createNewMedia(String data,  String type){
        return mediaService.createNewMedia(data, type);
    }
}

