package ddeliopoulos.github.gardenjournal.leaves;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LeavesService {

    public List<Leaves> getLeaves() {
        return List.of(
                new Leaves(
                        1L,
                        "Green",
                        24
                )
        );
    }
}
