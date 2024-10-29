package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;

import seedu.address.model.Model;
import seedu.address.model.goods.GoodsCategories;

public class CategoryTextCompleter extends SimpleTextCompleter {
    @Override
    public List<String> listAllTexts(Model model) {
        return GoodsCategories.PARSER_VALUES;
    }
}
