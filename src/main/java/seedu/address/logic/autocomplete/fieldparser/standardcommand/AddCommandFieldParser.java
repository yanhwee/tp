package seedu.address.logic.autocomplete.fieldparser.standardcommand;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Optional;
import java.util.Set;

import seedu.address.logic.autocomplete.fieldparser.StandardCommandFieldParser;
import seedu.address.logic.parser.Prefix;

public class AddCommandFieldParser extends StandardCommandFieldParser {
    public AddCommandFieldParser() {
        super(Optional.empty(), Set.of(
                PREFIX_NAME, PREFIX_PHONE, PREFIX_ADDRESS, PREFIX_TAG));
    }
}
