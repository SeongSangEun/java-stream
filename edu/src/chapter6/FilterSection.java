package chapter6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterSection {

    public void positiveNumberFilter() {
        Stream<Integer> numberStream = Stream.of(3, -5, 7, 9, -13, 15);
        Stream<Integer> numberStream2 = Stream.of(3, -5, 7, 9, -13, 15);

        //filter 만 한다면 Stream<?> 타입으로 리턴됨.
        Stream<Integer> positiveNumberStream = numberStream.filter(x -> x > 0);

        // 이미 filter를 사용했다면 위 스트림을 재사용할 수 없음.
        List<Integer> positiveNumberList = numberStream2.filter(
                n -> n > 0
        ).collect(Collectors.toList());
        System.out.println("positiveNumberStream = " + positiveNumberStream);
        System.out.println("positiveNumberList = " + positiveNumberList);




    }
}
