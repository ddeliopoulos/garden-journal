package ddeliopoulos.github.gardenjournal.plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findAllByUserEmail(String email);

}
