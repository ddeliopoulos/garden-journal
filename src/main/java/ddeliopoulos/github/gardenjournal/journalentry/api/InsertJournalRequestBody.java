package ddeliopoulos.github.gardenjournal.journalentry.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public final class InsertJournalRequestBody {

    private final Long createdAt;
    @NotBlank
    private final String type;
    @NotNull
    private final Long mediaId;

}