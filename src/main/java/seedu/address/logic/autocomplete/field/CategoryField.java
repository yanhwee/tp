package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.CategoryTextCompleter;

public class CategoryField extends SimpleField<CategoryTextCompleter> {
    public CategoryField(TextWithCursor text) {
        super(text, new CategoryTextCompleter());
    }
}
