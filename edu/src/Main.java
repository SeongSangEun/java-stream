import util.Adder;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Integer result = add.apply(3, 5);
        System.out.println("apply = " + result);
    }
}
