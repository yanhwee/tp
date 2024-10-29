package seedu.address.logic.autocomplete.fieldparser.standardcommand;

import java.util.Optional;
import java.util.Set;

import seedu.address.logic.autocomplete.fieldparser.simplefield.NameFieldParser;
import seedu.address.logic.autocomplete.fieldparser.StandardCommandFieldParser;

public class DeleteCommandFieldParser extends StandardCommandFieldParser {
    public DeleteCommandFieldParser() {
        super(Optional.of(new NameFieldParser()), Set.of());
    }
}
