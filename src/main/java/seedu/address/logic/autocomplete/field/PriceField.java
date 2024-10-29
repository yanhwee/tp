package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.PriceTextCompleter;

public class PriceField extends SimpleField<PriceTextCompleter> {
    public PriceField(TextWithCursor text) {
        super(text, new PriceTextCompleter());
    }
}
