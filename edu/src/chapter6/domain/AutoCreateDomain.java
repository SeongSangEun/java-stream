package chapter6.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static chapter6.domain.Order.OrderStatus.*;

public class AutoCreateDomain {

    public List<User> createUserList() {
        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@test.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@test.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("cahrlie@test.co.kr");

        return Arrays.asList(user1, user2, user3);
    }

    public List<Order> createOrderList() {
        Order order1 = new Order()
                .setId(101)
                .setStatus(CREATED)
                .setCreatedAt(LocalDateTime.now().minusHours(4))
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(102)
                .setStatus(ERROR)
                .setCreatedAt(LocalDateTime.now().minusHours(1))
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(103)
                .setStatus(IN_PROGRESS)
                .setCreatedAt(LocalDateTime.now().minusHours(36))
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(104)
                .setStatus(ERROR)
                .setCreatedAt(LocalDateTime.now().minusHours(40))
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(105)
                .setStatus(PROCESSED)
                .setCreatedAt(LocalDateTime.now().minusHours(10))
                .setCreatedByUserId(101);

        return Arrays.asList(order1, order2, order3, order4, order5);
    }

    public List<Order> createOrderLineList() {
        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));

        return Arrays.asList(order1, order2, order3);
    }
}
