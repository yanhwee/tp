package seedu.address.logic.autocomplete.fieldparser.standardcommand;

import java.util.Optional;
import java.util.Set;

import seedu.address.logic.autocomplete.fieldparser.StandardCommandFieldParser;
import seedu.address.logic.parser.Prefix;

public class HelpCommandFieldParser extends StandardCommandFieldParser {
    public HelpCommandFieldParser() {
        super(Optional.empty(), Set.of());
    }
}
