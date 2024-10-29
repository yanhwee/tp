package seedu.address.logic.autocomplete.textcompleter;

import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.model.Model;

public interface TextCompleter {
    TextCompletion complete(String text, Model model);
}
