package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBySection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    public void orderGrouping() {
        List<Order> orderList = autoCreateDomain.createOrderList();
        //스테이터스가 같은 오더끼리 그룹핑하기
        Map<Order.OrderStatus, List<Order>> orderStatusListMap = orderList.stream().collect(Collectors.groupingBy(Order::getStatus,
                Collectors.mapping(Function.identity(), Collectors.toList())));
        Map<Order.OrderStatus, List<Order>> orderStatusListMap1 = orderList.stream().collect(Collectors.groupingBy(Order::getStatus));
        System.out.println("orderStatusListMap = " + orderStatusListMap);
        System.out.println("orderStatusListMap1 = " + orderStatusListMap1);

        //orderStatus, sumOfAmount
        Map<Order.OrderStatus, BigDecimal> statusToSumOfAmount = orderList.stream().collect(
                Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.mapping(
                                Order::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println("statusToSumOfAmount = " + statusToSumOfAmount);

    }


    public void integerGrouping() {

        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 502, 502, 1213, 1231230, 258, 111);

        //1의자리수가 같은것 끼리 맵핑하기
        Map<Integer, List<Integer>> unitDigiMap = numbers.stream().collect(Collectors.groupingBy(number -> number % 10));
        System.out.println("unitDigiMap = " + unitDigiMap);

        // 데이터를 map의 키로 변환하는 Function, 데이터를 value로 변환하는 Fuction
        Map<Integer, Set<Integer>> unitDigiSet = numbers.stream().collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println("unitDigiSet = " + unitDigiSet);

        // 키는 이것, value는 이것이다
        Map<Integer, List<String>> unitDigitStrMap = numbers.stream().collect(Collectors.groupingBy(number -> number % 10,
                Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));
        System.out.println("unitDigitStrMap = " + unitDigitStrMap);
    }
}
