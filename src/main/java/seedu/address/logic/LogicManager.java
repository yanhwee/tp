package seedu.address.logic;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.autocomplete.AutocompleteResult;
import seedu.address.logic.autocomplete.TextCompletion;
import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.Field;
import seedu.address.logic.autocomplete.fieldparser.MainFieldParser;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.goodsreceipt.GoodsReceipt;
import seedu.address.model.person.Person;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_FORMAT = "Could not save data due to the following error: %s";

    public static final String FILE_OPS_PERMISSION_ERROR_FORMAT =
            "Could not save data to file %s due to insufficient permissions to write to the file or the folder.";

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = addressBookParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveAddressBook(model.getAddressBook());
            storage.saveGoods(model.getGoods());
        } catch (AccessDeniedException e) {
            throw new CommandException(String.format(FILE_OPS_PERMISSION_ERROR_FORMAT, e.getMessage()), e);
        } catch (IOException ioe) {
            throw new CommandException(String.format(FILE_OPS_ERROR_FORMAT, ioe.getMessage()), ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return model.getAddressBook();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public ObservableList<GoodsReceipt> getFilteredReceiptsList() {
        return model.getFilteredReceiptsList();
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }

    @Override
    public Optional<AutocompleteResult> autocomplete(String text, int cursor) {
        String preText = text.substring(0, cursor);
        String postText = text.substring(cursor);
        Optional<Field> field = new MainFieldParser()
                .parse(new TextWithCursor(preText, postText));
        return field.map(f -> {
            TextCompletion textCompletion = f.complete(model);
            String completion = textCompletion.completion();
            List<String> continuations = textCompletion.continuations();
            String newPreText = preText + f.text().postText() + completion;
            String newPostText = postText.substring(
                    Integer.min(f.text().postText().length(), postText.length()));
            int newCursor = newPreText.length();
            String newText = newPreText + newPostText;
            String completeText = f.text().fullText() + completion;
            String display = continuations
                    .stream()
                    .map(s -> completeText + s)
                    .collect(Collectors.joining(", "));
            logger.info(String.format("HELLO: %s, %s, %s, %d",
                    f.text().preText(), f.text().postText(), completion, newCursor));
            return new AutocompleteResult(newText, newCursor, display);
        });
    }
}
