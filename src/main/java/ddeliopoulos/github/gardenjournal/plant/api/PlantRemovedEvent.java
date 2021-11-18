package ddeliopoulos.github.gardenjournal.plant.api;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public final class PlantRemovedEvent extends ApplicationEvent {
    private final Long plantId;

    public PlantRemovedEvent(Object source, Long plantId) {
        super(source);
        this.plantId = plantId;
    }
}
