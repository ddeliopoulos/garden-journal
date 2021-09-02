package ddeliopoulos.github.gardenjournal.media;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/media")
class MediaController {

    private final MediaService mediaService;

    @GetMapping("/{mediaId}")
    String getMediaById(@PathVariable Long mediaId) {
        return mediaService.getMedia(mediaId);
    }
}
