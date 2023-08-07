import util.Adder;
import util.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> myStringSupplier = () -> "hello world";

        System.out.println("myStringSupplier = " + myStringSupplier.get());

        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();
        printRandomDoubles(myRandomDoubleSupplier, 5);
    }

    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count) {
        for (int i = 0; i < count; i ++) {
            System.out.println(randomSupplier.get());
        }
    }
}
