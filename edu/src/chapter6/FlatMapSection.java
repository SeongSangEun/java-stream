package chapter6;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.OrderLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();


    public void basicFlatMapMethod() {
        String[][] cities = new String[][] {
                {"Seoul", "Busan"},
                {"LA", "New york"},
                {"Madrid", "Barcelona"}
        };
        Stream<String[]> cityStream = Arrays.stream(cities);

        Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> stringStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> cityList = stringStream.collect(Collectors.toList());
        System.out.println("cityList = " + cityList);
    }

    public void orderFlatMap() {
        List<Order> orderList = autoCreateDomain.createOrderLineList();

        //내 풀이
        List<OrderLine> orderLineList = orderList.stream()
                .flatMap(o -> o.getOrderLines().stream()
                ).collect(Collectors.toList());

        //강의 풀이
        List<OrderLine> orderLineList2 = orderList.stream()  // Stream<Order>
                .map(Order::getOrderLines)                   // Stream<List<OrderLine>>
                .flatMap(List::stream)                       // Stream<OrderLine>
                .collect(Collectors.toList());


        System.out.println("orderLineList = " + orderLineList);
        System.out.println("orderLineList2 = " + orderLineList2);
    }

}
