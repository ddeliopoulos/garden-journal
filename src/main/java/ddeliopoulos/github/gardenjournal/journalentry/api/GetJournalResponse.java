package ddeliopoulos.github.gardenjournal.journalentry.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class GetJournalResponse {

    private final String Text;
    private final String Image;
    private final String Audio;

}
