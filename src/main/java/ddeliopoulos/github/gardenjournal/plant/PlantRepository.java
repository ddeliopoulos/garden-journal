package ddeliopoulos.github.gardenjournal.plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlantRepository extends JpaRepository<Plant, Long> {

}
