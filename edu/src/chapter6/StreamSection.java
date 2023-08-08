package chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSection {

    public void StreamToCollection() {
        Stream<String> nameStream = Stream.of("sangeun", "naye", "jun");
        List<String> nameList = nameStream.collect(Collectors.toList());
        System.out.println("nameList = " + nameList);

        String[] cityArray = new String[] {"seoul", "pyeongtaek", "suwon"};
        Stream<String> cityStream = Arrays.stream(cityArray);
        Set<String> citySet = cityStream.collect(Collectors.toSet());
        System.out.println("citySet = " + citySet);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7, 9));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberList = numberStream.collect(Collectors.toList());
        System.out.println("numberList = " + numberList);
    }

}
