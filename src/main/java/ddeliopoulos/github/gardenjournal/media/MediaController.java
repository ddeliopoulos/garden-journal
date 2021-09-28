package ddeliopoulos.github.gardenjournal.media;

import ddeliopoulos.github.gardenjournal.media.api.MediaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/media")
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("/{mediaId}")
    public ResponseEntity<String> getMediaById(@PathVariable Long mediaId) {
        MediaResponseDTO media = mediaService.getMedia(mediaId);

        return ResponseEntity.ok()
                             .header("CoNtEnT-tYpE", media.getContentType())
                             .body(media.getData());
    }
}
