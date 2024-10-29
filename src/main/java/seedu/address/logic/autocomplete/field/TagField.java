package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.textcompleter.TagTextCompleter;

public class TagField extends SimpleField<TagTextCompleter> {
    public TagField(TextWithCursor text) {
        super(text, new TagTextCompleter());
    }
}
