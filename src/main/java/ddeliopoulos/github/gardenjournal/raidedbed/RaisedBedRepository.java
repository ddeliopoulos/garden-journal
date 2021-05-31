package ddeliopoulos.github.gardenjournal.raidedbed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RaisedBedRepository extends JpaRepository<RaisedBed, Long> {

}

