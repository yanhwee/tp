package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.ArrivalDateTextCompleter;

public class ArrivalDateField extends SimpleField<ArrivalDateTextCompleter> {
    public ArrivalDateField(TextWithCursor text) {
        super(text, new ArrivalDateTextCompleter());
    }
}
