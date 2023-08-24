package chapter8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsSection {

    public void collectorsMethod() {
        List<Integer> numberList = Stream.of(3, 5, -3, 6, 1).collect(Collectors.toList());
        Set<Integer> numberSet = Stream.of(3, 5, -3, 6, 1).collect(Collectors.toSet());
        List<Integer> numberList2 = Stream.of(3, 5, -3, 6, 1)
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList()));

        Integer sum = Stream.of(3, 5, -3, 6, 1)
                .collect(Collectors.reducing(0, (x, y) -> x + y));
        System.out.println("sum = " + sum);


    }
}
