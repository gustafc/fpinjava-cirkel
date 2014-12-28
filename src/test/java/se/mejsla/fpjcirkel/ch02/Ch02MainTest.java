package se.mejsla.fpjcirkel.ch02;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Ch02MainTest {

    @Test
    public void testJoinWithFinalSeparator(){
        assertEquals("", joinWithAnd());
        assertEquals("apelsin", joinWithAnd("apelsin"));
        assertEquals("apelsin and banan", joinWithAnd("apelsin", "banan"));
        assertEquals("apelsin, banan and citron", joinWithAnd("apelsin", "banan", "citron"));
    }

    private String joinWithAnd(String... strings) {
        return Ch02Main.joinWithFinalSeparator(Arrays.asList(strings), ", ", " and ");
    }


}