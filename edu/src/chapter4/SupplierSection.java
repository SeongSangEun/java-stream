package chapter4;

import java.util.function.Supplier;

public class SupplierSection {

    public void myStringSupplierMethod() {
        Supplier<String> myStringSupplier = () -> "hello world";

        System.out.println("myStringSupplier = " + myStringSupplier.get());
    }

    public void myRandomDoubleSupplierMethod() {
        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        printRandomDoubles(myRandomDoubleSupplier, 5);
    }

    void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i ++) {
            System.out.println(randomSupplier.get());
        }
    }
}

