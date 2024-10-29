package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;

import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddGoodsCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteGoodsCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListGoodsCommand;
import seedu.address.model.Model;

public class CommandWordTextCompleter extends SimpleTextCompleter {

    private static final List<String> COMMAND_WORDS = List.of(
            AddCommand.COMMAND_WORD,
            AddGoodsCommand.COMMAND_WORD,
            ClearCommand.COMMAND_WORD,
            DeleteCommand.COMMAND_WORD,
            DeleteGoodsCommand.COMMAND_WORD,
            EditCommand.COMMAND_WORD,
            ExitCommand.COMMAND_WORD,
            FindCommand.COMMAND_WORD,
            HelpCommand.COMMAND_WORD,
            ListCommand.COMMAND_WORD,
            ListGoodsCommand.COMMAND_WORD
    );

    @Override
    public List<String> listAllTexts(Model model) {
        return COMMAND_WORDS;
    }
}
