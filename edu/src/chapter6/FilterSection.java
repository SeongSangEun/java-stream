package chapter6;

import chapter6.domain.Order;
import chapter6.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static chapter6.domain.Order.OrderStatus.*;

public class FilterSection {

    public void userFilter() {
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@test.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@test.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("cahrlie@test.co.kr");

        List<User> userList = Arrays.asList(user1, user2, user3);

        List<User> verifiedUsers = userList.stream().filter(User::isVerified).collect(Collectors.toList());
        List<User> unVerifiedUsers = userList.stream().filter(user -> !user.isVerified()).collect(Collectors.toList());
        System.out.println("verifiedUsers = " + verifiedUsers);
        System.out.println("unVerifiedUsers = " + unVerifiedUsers);
    }
    public void orderFilter() {

        Order order1 = new Order()
                .setId(101)
                .setStatus(CREATED);
        Order order2 = new Order()
                .setId(102)
                .setStatus(ERROR);
        Order order3 = new Order()
                .setId(103)
                .setStatus(IN_PROGRESS);
        Order order4 = new Order()
                .setId(104)
                .setStatus(ERROR);
        Order order5 = new Order()
                .setId(105)
                .setStatus(PROCESSED);

        List<Order> orderList = Arrays.asList(order1, order2, order3, order4, order5);

        List<Order> errorList = orderList.stream().filter(order -> ERROR.equals(order.getStatus())).collect(Collectors.toList());
        System.out.println("errorList = " + errorList);

    }


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
