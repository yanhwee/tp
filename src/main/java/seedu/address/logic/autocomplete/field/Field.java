package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.model.Model;

public interface Field {

    TextWithCursor text();
    TextCompletion complete(Model model);
}