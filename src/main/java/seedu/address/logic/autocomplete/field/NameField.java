package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.NameTextCompleter;

public class NameField extends SimpleField<NameTextCompleter> {
    public NameField(TextWithCursor text) {
        super(text, new NameTextCompleter());
    }
}
