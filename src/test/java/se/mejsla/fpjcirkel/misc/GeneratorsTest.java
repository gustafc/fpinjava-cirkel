package se.mejsla.fpjcirkel.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class GeneratorsTest {

    @Test
    public void testGenerateWhile() {
        doGenerate(empty(), emptyList());
        doGenerate(of(""), asList(""));
        doGenerate(of("a"), asList("a", ""));
        doGenerate(of("ab"), asList("ab", "b", ""));
    }

    private void doGenerate(Optional<String> seed, List<String> expectedResult) {
        Stream<String> stream = Generators.generateWhile(seed, s -> s.isEmpty() ? empty() : Optional.of(s.substring(1)));
        assertEquals(expectedResult, stream.collect(toList()));
    }

}