package chapter6;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPipeLineSection {

    // SOURCE(소스)
    // Intermediate Operations(중간처리자) - 0개 이상의 filter, map등의 중간처리 이며 여러가지 중간 처리를 이어붙이는것이 가능함
    // Terminal Operation (종결처리) - Collect, Reduce 등

    public void orderFilterMap() {
        AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
        List<Order> orderList = autoCreateDomain.createOrderList();

        // TODO : Find orders in Error status and extract createdByUserIds as a list
        List<Long> errorUserIdList = orderList.stream()
                .filter(o -> o.getStatus().equals(Order.OrderStatus.ERROR))
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println("errorUserIdList = " + errorUserIdList);

        // TODO : Find Orders in ERROR status and created within 24 hours
        List<Long> errorUserIdList2 = orderList.stream()
                .filter(o -> o.getStatus().equals(Order.OrderStatus.ERROR))
                .filter(o -> o.getCreatedAt().isAfter(LocalDateTime.now().minusDays(1)))
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println("errorUserIdList2 = " + errorUserIdList2);
    }


    public void userFilterMap() {
        AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
        List<User> userList = autoCreateDomain.createUserList();

        //기존의 방식
        List<String> emailList = new ArrayList<>();
        for (User user : userList) {
            if(!user.isVerified()) {
                emailList.add(user.getEmailAddress());
            }
        }
        System.out.println("emailList = " + emailList);

        // 변경의 방식 (What to do?)
        List<String> emails = userList.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println("emails = " + emails);
    }
}
