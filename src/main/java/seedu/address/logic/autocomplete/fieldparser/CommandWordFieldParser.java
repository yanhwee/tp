package seedu.address.logic.autocomplete.fieldparser;

import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.CommandWordField;
import seedu.address.logic.autocomplete.field.Field;

public class CommandWordFieldParser implements FieldParser {

    @Override
    public Optional<Field> parse(TextWithCursor text) {
        String preText = text.preText();
        if (preText.contains(" ")) {
            return Optional.empty();
        }
        String postText = text.postText();
        int n = postText.indexOf(" ");
        if (n != -1) {
            postText = postText.substring(0, n);
        }
        return Optional.of(new CommandWordField(
                new TextWithCursor(preText, postText)));
    }
}
