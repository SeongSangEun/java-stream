package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    public void userIdToMap() {
        List<User> userList = autoCreateDomain.createUserList();

        Map<Integer, User> userIdMap = userList.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println("userIdMap = " + userIdMap);
    }

    public void orderToMap() {
        List<Order> orderList = autoCreateDomain.createOrderList();

        Map<Long, Order.OrderStatus> idToStatusMap = orderList.stream()
                .collect(Collectors.toMap(Order::getId, x -> x.getStatus() == null ? Order.OrderStatus.ERROR : x.getStatus()));
        System.out.println("idToStatusMap = " + idToStatusMap);

    }


    public void simpleIntegerMap() {
        Map<Integer, String> numberMap = Stream.of(3, 5, -4, 6, 2)
                .collect(Collectors.toMap(x -> x, x -> "Number is " + x));
        System.out.println("numberMap = " + numberMap);
        Map<Integer, String> numberMap1 = Stream.of(3, 5, -4, 6, 2)
                .collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
        System.out.println("numberMap1 = " + numberMap1);

    }
}
