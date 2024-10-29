package seedu.address.logic.autocomplete;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AutocompleteUtils {
    public static TextCompletion simpleComplete(String text, List<String> texts) {
        List<String> continuations = texts
                .stream()
                .filter(s -> s.startsWith(text))
                .map(s -> s.substring(text.length()))
                .toList();
        Integer n = continuations
                .stream()
                .map(String::length)
                .min(Integer::compareTo)
                .orElse(0);
        int m = IntStream
                .range(0, n)
                .dropWhile(i -> continuations
                        .stream()
                        .map(s -> s.charAt(i))
                        .distinct()
                        .limit(2)
                        .count() <= 1)
                .findFirst()
                .orElse(n);
        String completion = continuations.isEmpty()
                ? ""
                : continuations.get(0).substring(0, m);
        List<String> trimContinuations = continuations
                .stream()
                .map(s -> s.substring(m))
                .filter(s -> !s.isEmpty())
                .toList();
        return new TextCompletion(completion, trimContinuations);
    }

    public static String[] regexSplit(String string, String regex, int limit) {
        String c = IntStream
                .rangeClosed(0, 0xffff)
                .mapToObj(x -> String.valueOf((char) x))
                .filter(x -> !string.contains(x))
                .findAny()
                .get();
        String[] split = (string + c).split(regex, limit);
        int n = split.length - 1;
        split[n] = split[n].substring(0, split[n].length() - 1);
        return split;
    }
    // TODO change all the string.split in autocomplete to use this regex split.
}
