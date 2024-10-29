package seedu.address.logic.autocomplete;

import java.util.List;

public record TextCompletion(String completion, List<String> continuations) {
}
