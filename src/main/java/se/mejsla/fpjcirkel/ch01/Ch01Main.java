package se.mejsla.fpjcirkel.ch01;

import java.util.stream.Stream;

public class Ch01Main {

    public static String helloWorld() {
        return Stream.of("apelsin", "banan").noneMatch(s -> s.equals("citron")) ? "Hello, world!" : "Oj oj nej!";
    }

}
