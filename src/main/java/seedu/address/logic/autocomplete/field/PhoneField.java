package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.PhoneTextCompleter;
import seedu.address.logic.autocomplete.textcompleter.TextCompleter;

public class PhoneField extends SimpleField<PhoneTextCompleter> {
    public PhoneField(TextWithCursor text) {
        super(text, new PhoneTextCompleter());
    }
}
