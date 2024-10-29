package seedu.address.logic.autocomplete.fieldparser;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.fieldparser.FieldParser;

public class MultisetPrefixFieldParser implements FieldParser {

    private final Map<String, FieldParser> prefixFieldParsers;

    public MultisetPrefixFieldParser(Map<String, FieldParser> prefixFieldParsers) {
        this.prefixFieldParsers = prefixFieldParsers;
    }

    @Override
    public Optional<Field> parse(TextWithCursor text) {
        String preText = text.preText();
        String postText = text.postText();
        String fullText = text.fullText();
        // Check if cursor on prefix field (not prefix's field)
        boolean cursorOnPrefix = prefixFieldParsers
                .keySet()
                .stream()
                .anyMatch(s -> {
                    int a = preText.split(s).length - 1;
                    int b = postText.split(s).length - 1;
                    int c = fullText.split(s).length - 1;
                    return a + b != c;
                });
        if (cursorOnPrefix) {
            return Optional.empty();
        }
        // Get prefix's field
        Optional<String> prefix = prefixFieldParsers
                .keySet()
                .stream()
                .filter(p -> preText.split(p).length > 1)
                .min(Comparator.comparingInt(p -> {
                    String[] split = preText.split(p);
                    return split[split.length - 1].length();
                }));
        return prefix.flatMap(p -> {
            FieldParser fieldParser = prefixFieldParsers.get(p);
            String[] splitPreText = preText.split(p);
            String rightPreText = splitPreText[splitPreText.length - 1];
            String leftPostText = prefixFieldParsers
                    .keySet()
                    .stream()
                    .map(s -> postText.split(s, 2)[0])
                    .min(Comparator.comparingInt(String::length))
                    .orElse(postText);
            return fieldParser.parse(new TextWithCursor(rightPreText, leftPostText));
        });
    }
}
