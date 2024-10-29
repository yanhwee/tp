package seedu.address.logic.autocomplete.textcompleter;

import java.util.List;
import java.util.stream.Collectors;

import seedu.address.model.Model;

public class GoodsNameTextCompleter extends SimpleTextCompleter {

    @Override
    public List<String> listAllTexts(Model model) {
        return model.getGoods().getReceiptList()
                .stream()
                .map(g -> g.getGoods().getReadableGoodsName())
                .collect(Collectors.toList());
    }
}
