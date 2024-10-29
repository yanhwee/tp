package seedu.address.logic.autocomplete.fieldparser.simplefield;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.field.PriceField;
import seedu.address.logic.autocomplete.fieldparser.FieldParser;

public class PriceFieldParser implements FieldParser {
    @Override
    public Optional<Field> parse(TextWithCursor text) {
        return Optional.of(new PriceField(text));
    }
}
