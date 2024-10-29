package seedu.address.logic.autocomplete.fieldparser.simplefield;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.field.GoodsNameField;
import seedu.address.logic.autocomplete.fieldparser.FieldParser;

public class GoodsNameFieldParser implements FieldParser {
    @Override
    public Optional<Field> parse(TextWithCursor text) {
        return Optional.of(new GoodsNameField(text));
    }
}
