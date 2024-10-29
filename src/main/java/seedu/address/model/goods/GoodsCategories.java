package seedu.address.model.goods;

import java.util.List;

/**
 * Enum to represent Categories of Goods
 */
public enum GoodsCategories {
    CONSUMABLES,
    LIFESTYLE,
    SPECIALTY;

    public static final String MESSAGE_UNKNOWN_CATEGORY =
            "Category should strictly be one of [CONSUMABLES, LIFESTYLE, SPECIALTY]";

    public static final List<String> PARSER_VALUES = List.of("CONSUMABLES", "LIFESTYLE", "SPECIALTY");
}
