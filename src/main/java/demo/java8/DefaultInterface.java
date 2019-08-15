package demo.java8;

import java.util.function.Supplier;

public class DefaultInterface {
    private interface Defaulable {
        // Interfaces now allow default methods, the implementer may or
        // may not implement (override) them.
        default String defaultImpl() {
            return "Default implementation";
        }
    }

    private static class DefaultableImpl implements Defaulable {
    }

    private static class OverridableImpl implements Defaulable {
        @Override
        public String defaultImpl() {
            return "Overridden implementation";
        }
    }

    private interface DefaulableFactory {
        // Interfaces now allow static methods
        static Defaulable create(Supplier<Defaulable> supplier) {
            return supplier.get();
        }
    }

    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.defaultImpl());

        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.defaultImpl());
    }
}
