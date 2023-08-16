package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MaxMinCountSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    public void maxStreamMethod() {
        Optional<Integer> max = Stream.of(6, 3, 6, 2, 1)
                .max((x, y) -> x - y);
        Optional<Integer> max1 = Stream.of(6, 3, 6, 2, 1)
                .max(Integer::compareTo);

        Integer maxInt = max.orElse(0);
        System.out.println("maxInt = " + maxInt);
        Integer maxInt1 = max1.orElse(0);
        System.out.println("maxInt1 = " + maxInt);
    }

    public void userMinStreamMethod() {
        List<User> userList = autoCreateDomain.createUserList();

        Optional<User> firstUser = userList.stream()
                .min((u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println("firstUser = " + firstUser);
    }

    public void countStreamMethod() {
//        양수의 수 구하기
        long count = Stream.of(1, -2, 5, -8, 10)
                .filter(i -> i > 0)
                .count();
        System.out.println("count = " + count);
    }

    public void applyCountMethod() {
        //가입한 유저중 현재 시간 기준으로 아직 이메일 인증이 되지 않은 계정들
        List<User> userList = autoCreateDomain.createUserList();
        long count = userList.stream().filter(u -> u.getCreatedAt().isAfter(LocalDateTime.now().minusDays(1)))
                .filter(u -> !u.isVerified())
                .count();
        System.out.println("count = " + count);
    }

    public void applyOrderMethod() {
        List<Order> orderList = autoCreateDomain.createOrderList();

        //에러상태, 비싼 주문이 찾아내서 출력하기

        //내가 한것
        Order order = orderList.stream()
                .filter(o -> o.getStatus().equals(Order.OrderStatus.ERROR))
                .max(Comparator.comparing(Order::getAmount))
                .get();

        System.out.println("order = " + order);

        Order order1 = orderList.stream()
                .filter(or -> or.getStatus().equals(Order.OrderStatus.ERROR))
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .get();
        System.out.println("order1 = " + order1);

        //금액만 프린트
        BigDecimal maxAmount = orderList.stream()
                .filter(or -> or.getStatus().equals(Order.OrderStatus.ERROR))
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        System.out.println("maxAmount = " + maxAmount);

    }

}
