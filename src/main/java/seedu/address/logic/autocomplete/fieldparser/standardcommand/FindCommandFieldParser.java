package seedu.address.logic.autocomplete.fieldparser.standardcommand;

import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;

import java.util.Optional;
import java.util.Set;

import seedu.address.logic.autocomplete.fieldparser.simplefield.NameFieldParser;
import seedu.address.logic.autocomplete.fieldparser.StandardCommandFieldParser;

public class FindCommandFieldParser extends StandardCommandFieldParser {
    public FindCommandFieldParser() {
        super(Optional.of(new NameFieldParser()), Set.of(PREFIX_CATEGORY));
    }
}
