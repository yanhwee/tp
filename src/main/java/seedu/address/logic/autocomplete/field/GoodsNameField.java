package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.GoodsNameTextCompleter;

public class GoodsNameField extends SimpleField<GoodsNameTextCompleter> {
    public GoodsNameField(TextWithCursor text) {
        super(text, new GoodsNameTextCompleter());
    }
}
