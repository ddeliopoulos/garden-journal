package ddeliopoulos.github.gardenjournal.media;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MediaFacade {

    private final MediaService mediaService;

    public Long createNewMedia(String data){
        return mediaService.createNewMedia(data);
    }
}

