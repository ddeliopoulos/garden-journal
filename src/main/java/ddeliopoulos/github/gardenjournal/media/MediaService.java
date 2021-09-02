package ddeliopoulos.github.gardenjournal.media;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
class MediaService {

    private final MediaRepository mediaRepository;

    Long createNewMedia(String data) {
        final Media entity = new Media(
                null,
                data
        );

        final Media savedEntity = mediaRepository.save(entity);

        return savedEntity.getId();
    }

    String getMedia(Long mediaId) {
        return mediaRepository.findById(mediaId)
                              .map(Media::getData)
                              .orElseThrow(() -> new ResponseStatusException(
                                      HttpStatus.NOT_FOUND, "entity not found"
                              ));
    }
}
