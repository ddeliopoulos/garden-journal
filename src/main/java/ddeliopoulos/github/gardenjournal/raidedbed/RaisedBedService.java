package ddeliopoulos.github.gardenjournal.raidedbed;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RaisedBedService {

    public List<RaisedBed> getRaisedBed() {
        return List.of(
                new RaisedBed(
                        1L,
                        "Summer2021",
                        24,
                        96,
                        60
                )
        );
    }
}
