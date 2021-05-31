package ddeliopoulos.github.gardenjournal.leaves;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface LeavesRepository extends JpaRepository<Leaves, Long> {

}
