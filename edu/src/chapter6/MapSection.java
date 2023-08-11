package chapter6;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapSection {

    public void domainStreamMap() {
        AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

        List<User> userList = autoCreateDomain.createUserList();

        //유저들의 이메일만 들어있는 리스트를 만들기
        List<String> emailList = userList.stream().map(User::getEmailAddress).collect(Collectors.toList());
        System.out.println("emailList = " + emailList);

        List<Order> orderList = autoCreateDomain.createOrderList();
        // 오더 리스트에서 어떤 유저가 만들었는지 유저아이디들이 모여있는 리스트 만들기
        List<Long> orderedUserIdList = orderList.stream().map(Order::getCreatedByUserId).distinct().collect(Collectors.toList());
        System.out.println("orderedUserIdList = " + orderedUserIdList);


    }

    public void numberStreamMap() {
        List<Integer> numberList = Arrays.asList(3, 6, -4, 5, 10);

        List<Integer> numberStreamX2 = numberList.stream().map(x -> x * 2).collect(Collectors.toList());
        System.out.println("numberStreamX2 = " + numberStreamX2);

        List<String> StringResultList = numberList.stream().map(x -> "Number is " + x).collect(Collectors.toList());
        System.out.println("StringResultList = " + StringResultList);
    }
}
