package chapter6.domain;

import java.util.Arrays;
import java.util.List;

import static chapter6.domain.Order.OrderStatus.*;

public class AutoCreateDomain {

    public List<User> createUserList() {
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

        return Arrays.asList(user1, user2, user3);
    }

    public List<Order> createOrderList() {
        Order order1 = new Order()
                .setId(101)
                .setStatus(CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(102)
                .setStatus(ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(103)
                .setStatus(IN_PROGRESS)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(104)
                .setStatus(ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(105)
                .setStatus(PROCESSED)
                .setCreatedByUserId(101);

        return Arrays.asList(order1, order2, order3, order4, order5);
    }
}
