package ddeliopoulos.github.fridge.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface RefrigeratorRepository extends JpaRepository<Object, Long> {

    @Query("SELECT p from JournalEntry p")
    void bla();

}
