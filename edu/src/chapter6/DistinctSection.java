package chapter6;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    public void numberDistinct() {
        List<Integer> integers = Arrays.asList(3, 5, 3, 1, 2, 7, 9);

        List<Integer> integerList = integers.stream().distinct().collect(Collectors.toList());
        System.out.println("integerList = " + integerList);
        List<Integer> sortedInteger = integers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("sortedInteger = " + sortedInteger);
    }

    public void orderDistinct() {
        List<Order> orderList = autoCreateDomain.createOrderList();
        List<Long> userIdList = orderList.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("userIdList = " + userIdList);

    }
}
