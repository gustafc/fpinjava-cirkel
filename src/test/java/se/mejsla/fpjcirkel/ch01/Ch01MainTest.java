package se.mejsla.fpjcirkel.ch01;

import org.junit.Test;
import static org.junit.Assert.*;

public class Ch01MainTest {

    @Test
    public void testHelloWorld(){
        assertEquals("Hello, world!", Ch01Main.helloWorld());
    }

}