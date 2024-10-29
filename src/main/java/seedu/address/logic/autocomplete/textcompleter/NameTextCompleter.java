package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.Model;

public class NameTextCompleter extends SimpleTextCompleter {

    @Override
    public List<String> listAllTexts(Model model) {
        return model.getPersonList()
                .stream()
                .map(p -> p.getName().fullName)
                .collect(Collectors.toList());
    }
}
