package chapter6;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSection {

    List<Integer> numbers = Arrays.asList(3, -5, 7, 4, 11);
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    public void numberAscSorter() {
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("sortedNumbers = " + sortedNumbers);
    }

    public void sortedUserList() {
        List<User> userList = autoCreateDomain.createUserList();

        List<User> sortedUserList = userList.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());

        System.out.println("sortedUserList = " + sortedUserList);
    }

    public void sortedOrderList() {

        // TODO : sort the orders based on createdAt;
        List<Order> orderList = autoCreateDomain.createOrderList();

        List<LocalDateTime> sortedOrderTimeList = orderList.stream().sorted(
                (o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt())
        ).map(Order::getCreatedAt).collect(Collectors.toList());
        System.out.println("sortedOrderTimeList = " + sortedOrderTimeList);

    }
}
