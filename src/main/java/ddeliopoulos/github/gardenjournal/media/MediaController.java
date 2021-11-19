package ddeliopoulos.github.gardenjournal.media;

import ddeliopoulos.github.gardenjournal.media.api.MediaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/media")
public class MediaController {

    private final MediaService mediaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createMedia(@RequestBody byte[] data, @RequestParam("contentType") String contentType) {
        return mediaService.createNewMedia(data, contentType);
    }

    @GetMapping("/{mediaId}")
    public ResponseEntity<byte[]> getMediaById(@PathVariable Long mediaId) {
        MediaResponseDTO media = mediaService.getMedia(mediaId);

        return ResponseEntity.ok()
                             .header("CoNtEnT-tYpE", media.getContentType())
                             .body(media.getData());
    }
}
