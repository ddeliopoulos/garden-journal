package ddeliopoulos.github.gardenjournal.media;

import ddeliopoulos.github.gardenjournal.media.api.MediaResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RequiredArgsConstructor
@Service
class MediaService {

    private final MediaRepository mediaRepository;
    Long createNewMedia(byte[] data, String type) {
        final Media entity = new Media(
                null,
                data,
                type
        );
        final Media savedEntity = mediaRepository.save(entity);
        log.info("created new media! {} {}", type, savedEntity.getId());
        return savedEntity.getId();
    }

    MediaResponseDTO getMedia(Long mediaId) {
        log.info("got some media data! {}", mediaId);

        return mediaRepository.findById(mediaId)
                              .map(media -> new MediaResponseDTO(
                                      media.getData(),
                                      media.getContentType()
                              ))
                              .orElseThrow(() -> new ResponseStatusException(
                                      HttpStatus.NOT_FOUND, "entity not found"
                              ));
    }
}
