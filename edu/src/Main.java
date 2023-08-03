import util.Adder;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> myAdder = new Adder();
        Integer result = myAdder.apply(10);
        System.out.println("result = " + result);
    }
}
