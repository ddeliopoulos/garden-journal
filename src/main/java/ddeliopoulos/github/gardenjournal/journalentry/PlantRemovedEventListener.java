package ddeliopoulos.github.gardenjournal.journalentry;

import ddeliopoulos.github.gardenjournal.plant.api.PlantRemovedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class PlantRemovedEventListener implements ApplicationListener<PlantRemovedEvent> {

    private final JournalService journalService;

    @Override
    public void onApplicationEvent(PlantRemovedEvent event) {
        journalService.removeAllJournalEntries(event.getPlantId());
    }
}
