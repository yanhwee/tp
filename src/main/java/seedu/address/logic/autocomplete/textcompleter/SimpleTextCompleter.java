package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;

import seedu.address.logic.autocomplete.AutocompleteUtils;
import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.model.Model;

public abstract class SimpleTextCompleter implements TextCompleter {
    @Override
    public final TextCompletion complete(String text, Model model) {
        return AutocompleteUtils.simpleComplete(text, listAllTexts(model));
    }

    public abstract List<String> listAllTexts(Model model);
}
