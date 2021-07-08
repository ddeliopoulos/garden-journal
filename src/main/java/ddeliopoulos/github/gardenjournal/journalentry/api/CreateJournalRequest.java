package ddeliopoulos.github.gardenjournal.journalentry.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class CreateJournalRequest {

    private final String journalEntryText;
    private final String journalEntryImage;
    private final String journalEntryAudio;

}