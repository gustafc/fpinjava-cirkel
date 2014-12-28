package se.mejsla.fpjcirkel.ch02;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Ch02Main {

    public static <T> String joinWithFinalSeparator(List<T> list, String sep, String finalSep) {
        Stream<String> strings = list.stream().map(String::valueOf);
        if (list.size() <= 1) return strings.findFirst().orElse("");
        int lastIndex = list.size() - 1;
        return strings.limit(lastIndex).collect(joining(sep)) + finalSep + list.get(lastIndex);
    }

}
