package seedu.address.logic.autocomplete.fieldparser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ARRIVAL_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CATEGORY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GOODS_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRICE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PROCUREMENT_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.fieldparser.simplefield.AddressFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.ArrivalDateFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.CategoryFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.GoodsNameFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.NameFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.PhoneFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.PriceFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.ProcurementDateFieldParser;
import seedu.address.logic.autocomplete.fieldparser.simplefield.TagFieldParser;
import seedu.address.logic.parser.Prefix;

public class StandardCommandFieldParser implements FieldParser {

    private final Optional<FieldParser> preambleFieldParser;
    private final Map<String, FieldParser> prefixFieldParsers;

    private final Map<Prefix, FieldParser> STANDARD_PREFIX_FIELD_PARSERS = Map.of(
            PREFIX_NAME, new NameFieldParser(),
            PREFIX_PHONE, new PhoneFieldParser(),
            PREFIX_ADDRESS, new AddressFieldParser(),
            PREFIX_TAG, new TagFieldParser(),
            PREFIX_GOODS_NAME, new GoodsNameFieldParser(),
//            PREFIX_PRICE, new PriceFieldParser(),
            PREFIX_CATEGORY, new CategoryFieldParser(),
            PREFIX_PROCUREMENT_DATE, new ProcurementDateFieldParser(),
            PREFIX_ARRIVAL_DATE, new ArrivalDateFieldParser()
    );

    public StandardCommandFieldParser(Optional<FieldParser> preambleFieldParser, Set<Prefix> prefixes) {
        assert prefixes
                .stream()
                .allMatch(STANDARD_PREFIX_FIELD_PARSERS::containsKey);
        this.preambleFieldParser = preambleFieldParser;
        this.prefixFieldParsers = prefixes
                .stream()
                .collect(
                        HashMap::new,
                        (m, prefix) -> m.put(
                                "\\s*" + prefix.getPrefix(),
                                STANDARD_PREFIX_FIELD_PARSERS.get(prefix)),
                        HashMap::putAll);
    }

    @Override
    public Optional<Field> parse(TextWithCursor text) {
        if (preambleFieldParser.isEmpty()) {
            return new MultisetPrefixFieldParser(prefixFieldParsers).parse(text);
        }
        String preText = text.preText();
        String postText = text.postText();
        String[] splitPreText = prefixFieldParsers
                .keySet()
                .stream()
                .map(s -> preText.split(s, 2))
                .min(Comparator.comparingInt(arr -> arr[0].length()))
                .orElse(new String[] {preText});
        if (splitPreText.length >= 2) {
            String leftPreText = splitPreText[0];
            String rightPreText = preText.substring(leftPreText.length());
            return new MultisetPrefixFieldParser(prefixFieldParsers)
                    .parse(new TextWithCursor(rightPreText, postText));
        }
        String leftPostText = prefixFieldParsers
                .keySet()
                .stream()
                .map(s -> postText.split(s, 2)[0])
                .min(Comparator.comparingInt(String::length))
                .orElse(postText);
        return preambleFieldParser.get()
                .parse(new TextWithCursor(preText, leftPostText));
    }
}
