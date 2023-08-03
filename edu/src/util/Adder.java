package util;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer x) {
        return x + 10;
    }

    @Override
    public <V> Function<V, Integer> compose(Function<? super V, ? extends Integer> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<Integer, V> andThen(Function<? super Integer, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
