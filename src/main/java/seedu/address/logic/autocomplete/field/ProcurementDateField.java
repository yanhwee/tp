package seedu.address.logic.autocomplete.field;

import seedu.address.logic.autocomplete.TextWithCursor;
import seedu.address.logic.autocomplete.field.SimpleField;
import seedu.address.logic.autocomplete.textcompleter.ProcurementDateTextCompleter;

public class ProcurementDateField extends SimpleField<ProcurementDateTextCompleter> {
    public ProcurementDateField(TextWithCursor text) {
        super(text, new ProcurementDateTextCompleter());
    }
}
