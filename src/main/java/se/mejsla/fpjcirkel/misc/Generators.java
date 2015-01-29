package se.mejsla.fpjcirkel.misc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Generators {

    private Generators() {
    }


    public static <T> Stream<T> generateWhile(Optional<? extends T> seed, Function<? super T, Optional<? extends T>> progress) {
        Iterator<T> iterator = new Iterator<T>() {
            Optional<? extends T> nextElement = seed;

            @Override
            public boolean hasNext() {
                return nextElement.isPresent();
            }

            @Override
            public T next() {
                T value = nextElement.get();
                nextElement = progress.apply(value);
                return value;
            }
        };
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED | Spliterator.IMMUTABLE),
                false);
    }
}
