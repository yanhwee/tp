package seedu.address.logic.autocomplete.fieldparser;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;

public interface FieldParser {
    Optional<Field> parse(TextWithCursor text);
}
