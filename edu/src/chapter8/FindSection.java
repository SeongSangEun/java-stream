package chapter8;

import java.util.Optional;
import java.util.stream.Stream;

public class FindSection {

    public void findMethod() {
        //일반적으로 filter와 연계를 사용하여 사용

        Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6, 8, -3)
                .filter(x -> x < 0)
                .findAny();
        System.out.println("anyNegativeInteger.get() = " + anyNegativeInteger.get());

        Optional<Integer> firstPositiveInteger = Stream.of(3, 2, -5, -6)
                .filter(x -> x > 0)
                .findFirst();
        System.out.println("firstPositiveInteger.get() = " + firstPositiveInteger.get());
        Optional<Integer> sortedFirstPositiveInteger = Stream.of(3, 2, -5, -6)
                .filter(x -> x > 0)
                .sorted()
                .findFirst();
        System.out.println("sortedFirstPositiveInteger.get() = " + sortedFirstPositiveInteger.get());

    }

}
