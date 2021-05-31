package ddeliopoulos.github.gardenjournal.raidedbed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/raisedbed")

public class RaisedBedController {
    private final RaisedBedService raisedBedService;

    @Autowired
    public RaisedBedController(RaisedBedService raisedBedService) {
        this.raisedBedService = raisedBedService;
    }

    @GetMapping
    public List<RaisedBed> getRaisedBed() {
        return raisedBedService.getRaisedBed();
    }

}
