package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.Model;

public class TagTextCompleter extends SimpleTextCompleter {

    @Override
    public List<String> listAllTexts(Model model) {
        return model.getPersonList()
                .stream()
                .flatMap(p -> p.getTags()
                        .stream()
                        .map(t -> t.tagName))
                .collect(Collectors.toList());
    }
}
