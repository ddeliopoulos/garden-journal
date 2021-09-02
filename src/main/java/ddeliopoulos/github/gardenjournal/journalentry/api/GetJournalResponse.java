package ddeliopoulos.github.gardenjournal.journalentry.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class GetJournalResponse {

    private final Long createdAt;
    private final String type;
    private final String data;

}
