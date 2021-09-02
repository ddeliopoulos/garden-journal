package ddeliopoulos.github.gardenjournal.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface MediaRepository extends JpaRepository<Media, Long> {
}