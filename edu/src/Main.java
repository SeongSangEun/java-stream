import util.Adder;
import util.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x+y+z;
        Integer result = addThreeNumbers.apply(1, 2, 3);
        System.out.println("result = " + result);

    }
}
