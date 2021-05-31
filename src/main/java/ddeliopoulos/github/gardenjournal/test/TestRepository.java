package ddeliopoulos.github.gardenjournal.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
interface TestRepository extends JpaRepository<Test, Long> {

    // give us all tests not older than 7 days
    // select * from db.tests t where t.created_at >= date_sub(now(), interval 7 day)

//    @Query("select t from db.tests t where t.created_at >= date_sub(now(), interval 7 day)")
//    List<Test> getAllInLast7Days();

    List<Test> findByCreatedAtAfter(final Date after);

}
