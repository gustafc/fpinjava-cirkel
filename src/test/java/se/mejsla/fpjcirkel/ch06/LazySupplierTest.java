package se.mejsla.fpjcirkel.ch06;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.function.Supplier;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LazySupplierTest {

    private Supplier<String> target;
    private LazySupplier<String> instance;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        target = mock(Supplier.class);
        when(target.get())
                .thenReturn("first call")
                .thenThrow(new IllegalStateException("get() called multiple times"));
        instance = new LazySupplier<>(target);
    }

    @Test
    public void shouldCallTargetOnce(){
        assertEquals("first call", instance.get());
        assertEquals("first call", instance.get());
    }

    @Test
    public void shouldBeLazy(){
        assertEquals("first call", target.get()); // First call to target succeeds
        exception.expectMessage("get() called multiple times");
        instance.get(); // Should perform a second call and fail
        fail("unreachable code");
    }

}