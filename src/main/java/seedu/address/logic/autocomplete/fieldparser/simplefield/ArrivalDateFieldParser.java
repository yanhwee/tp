package seedu.address.logic.autocomplete.fieldparser.simplefield;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.ArrivalDateField;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.fieldparser.FieldParser;

public class ArrivalDateFieldParser implements FieldParser {
    @Override
    public Optional<Field> parse(TextWithCursor text) {
        return Optional.of(new ArrivalDateField(text));
    }
}
