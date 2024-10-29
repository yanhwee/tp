package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.SimpleField;
import seedu.address.logic.autocomplete.textcompleter.QuantityTextCompleter;

public class QuantityField extends SimpleField<QuantityTextCompleter> {
    public QuantityField(TextWithCursor text) {
        super(text, new QuantityTextCompleter());
    }
}
