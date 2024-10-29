package seedu.address.logic.autocomplete.fieldparser;

import java.util.Map;
import java.util.Optional;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.fieldparser.simplefield.AddGoodsCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.AddCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.ClearCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.DeleteCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.DeleteGoodsCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.EditCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.FindCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.HelpCommandFieldParser;
import seedu.address.logic.autocomplete.fieldparser.standardcommand.ListCommandFieldParser;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddGoodsCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteGoodsCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;

public class CommandWordAndCommandsFieldParser implements FieldParser {

    private final FieldParser COMMAND_WORD_FIELD_PARSER = new CommandWordFieldParser();

    private final Map<String, FieldParser> COMMAND_FIELD_PARSERS = Map.of(
            AddCommand.COMMAND_WORD, new AddCommandFieldParser(),
            ClearCommand.COMMAND_WORD, new ClearCommandFieldParser(),
            DeleteCommand.COMMAND_WORD, new DeleteCommandFieldParser(),
            EditCommand.COMMAND_WORD, new EditCommandFieldParser(),
            FindCommand.COMMAND_WORD, new FindCommandFieldParser(),
            ListCommand.COMMAND_WORD, new ListCommandFieldParser(),
            HelpCommand.COMMAND_WORD, new HelpCommandFieldParser(),
            AddGoodsCommand.COMMAND_WORD, new AddGoodsCommandFieldParser(),
            DeleteGoodsCommand.COMMAND_WORD, new DeleteGoodsCommandFieldParser()
    );

    private final static String DELIMITER = "\\s+";

    // TODO: Add view and export command.

    @Override
    public Optional<Field> parse(TextWithCursor text) {
        String preText = text.preText();
        String postText = text.postText();
        String[] splitPreText = preText.split(DELIMITER, 2);
        if (splitPreText.length < 2) {
            String leftPostText = postText.split(DELIMITER, 2)[0];
            return COMMAND_WORD_FIELD_PARSER.parse(new TextWithCursor(preText, leftPostText));
        }
        String leftPreText = splitPreText[0];
        String rightPreText = splitPreText[1];
        if (!COMMAND_FIELD_PARSERS.containsKey(leftPreText)) {
            return Optional.empty();
        }
        FieldParser fieldParser = COMMAND_FIELD_PARSERS.get(leftPreText);
        return fieldParser.parse(new TextWithCursor(rightPreText, postText));
    }
}
