package seedu.address.logic.autocomplete;

import static java.util.Objects.requireNonNull;

public record TextWithCursor(String preText, String postText) {

    public TextWithCursor(String preText, String postText) {
        requireNonNull(preText);
        requireNonNull(postText);
        assert !preText.startsWith(" ");
        this.preText = preText;
        this.postText = postText;
    }

    public String fullText() {
        return preText + postText;
    }
}
