package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.AddressTextCompleter;

public class AddressField extends SimpleField<AddressTextCompleter> {
    public AddressField(TextWithCursor text) {
        super(text, new AddressTextCompleter());
    }
}
