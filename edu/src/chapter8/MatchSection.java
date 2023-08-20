package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.util.Arrays;
import java.util.List;

public class MatchSection {

    public void integerMatch() {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 6);

        //모든 수가 양수인지?
        boolean allPositive = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println("allPositive = " + allPositive); // false

        //하나라도 음수?
        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        System.out.println("anyNegative = " + anyNegative);
    }

    public void userMatch() {
        AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
        List<User> userList = autoCreateDomain.createUserList();

        //유저 전부가 인증이 끝났는지?
        boolean isVerifiedAll = userList.stream()
                .allMatch(u -> u.isVerified());
        boolean isVerifiedAll2 = userList.stream()
                .allMatch(User::isVerified);

        System.out.println("isVerifiedAll = " + isVerifiedAll);
        System.out.println("isVerifiedAll2 = " + isVerifiedAll2);

        List<Order> orderList = autoCreateDomain.createOrderList();

        // 오더 리스트 내 에러상태의 오더가 하나 이상 있는지? 있다면 트루로 리턴
        boolean hasErrorStatus = orderList.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println("hasErrorStatus = " + hasErrorStatus);
    }

}
