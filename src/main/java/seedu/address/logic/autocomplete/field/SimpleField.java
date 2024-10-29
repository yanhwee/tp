package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.logic.autocomplete.textcompleter.TextCompleter;
import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.model.Model;

public class SimpleField<T extends TextCompleter> implements Field {

    private final TextWithCursor text;
    private final T textCompleter;

    public SimpleField(TextWithCursor text, T textCompleter) {
        this.text = text;
        this.textCompleter = textCompleter;
    }

    @Override
    public TextWithCursor text() {
        return text;
    }

    @Override
    public TextCompletion complete(Model model) {
        return textCompleter.complete(text.fullText(), model);
    }
}
