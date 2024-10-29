package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.textcompleter.CommandWordTextCompleter;
import seedu.address.logic.autocomplete.TextWithCursor;

public class CommandWordField extends SimpleField<CommandWordTextCompleter> {
    public CommandWordField(TextWithCursor text) {
        super(text, new CommandWordTextCompleter());
    }
}
