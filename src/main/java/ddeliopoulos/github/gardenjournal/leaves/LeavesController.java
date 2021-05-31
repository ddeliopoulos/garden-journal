package ddeliopoulos.github.gardenjournal.leaves;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/leaves")

public class LeavesController {
    private final LeavesService leavesService;

    @Autowired
    public LeavesController(LeavesService leavesService) {
        this.leavesService = leavesService;
    }

    @GetMapping
    public List<Leaves> getLeaves() {
        return leavesService.getLeaves();
    }

}
