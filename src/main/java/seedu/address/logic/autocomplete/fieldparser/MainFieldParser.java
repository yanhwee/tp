package seedu.address.logic.autocomplete.fieldparser;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;

public class MainFieldParser implements FieldParser {
    @Override
    public Optional<Field> parse(TextWithCursor text) {
        String preText = text.preText();
        String postText = text.postText();
        preText = preText.stripLeading();
        return new CommandWordAndCommandsFieldParser()
                .parse(new TextWithCursor(preText, postText));
    }
}
