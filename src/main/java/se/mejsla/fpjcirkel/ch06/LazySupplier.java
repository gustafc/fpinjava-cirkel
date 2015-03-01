package se.mejsla.fpjcirkel.ch06;


import java.util.function.Supplier;

public class LazySupplier<T> implements Supplier<T> {
    private volatile Supplier<T> actualSupplier;

    public LazySupplier(Supplier<T> constructor) {
        actualSupplier = constructor;
    }


    @Override
    public T get() {
        Supplier<T> supplier = actualSupplier;
        if (!(supplier instanceof ConstantSupplier)) {
            synchronized (this) {
                supplier = actualSupplier; // Might have changed when waiting for lock
                if (!(supplier instanceof ConstantSupplier)) {
                    actualSupplier = supplier = new ConstantSupplier<>(supplier.get());
                }
            }
        }
        return supplier.get();
    }

    private static final class ConstantSupplier<T> implements Supplier<T> {
        private final T value;

        private ConstantSupplier(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }
    }

}
