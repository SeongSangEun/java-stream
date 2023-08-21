package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.Order;
import chapter6.domain.OrderLine;
import chapter6.domain.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ReduceSection {

    public void reduceMethod() {
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        Integer sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println("sum = " + sum);

        //내가 만든 최댓값, 최솟값
        Integer max = numbers.stream()
                .reduce((x, y) -> x > y ? x : y)
                .get();
        System.out.println("max = " + max);
        Integer min = numbers.stream()
                .reduce((x, y) -> x < y ? x : y)
                .get();
        System.out.println("min = " + min);

        //강의자료
        Integer max1 = numbers.stream()
                .reduce((x, y) -> {
                    if (x < y) {
                        return x;
                    }
                    return y;
                }).get();
        System.out.println("max1 = " + max1); // 이것을 결국 위와 같이 삼항연산자로 변환

        //모든 수의 곱셈값을 구함
        // 이때 초기값 1을 설정함으로 값이 예외상황을 커버
        // 초기값을 제공함으로 get을 할 필요가 없는 T 타입이 리턴됨 확인
        Integer multiple = numbers.stream()
                .reduce(1, (x, y) -> x * y);

        System.out.println("multiple = " + multiple);


        List<String> numberStringList = Arrays.asList("3", "2", "5", "-4");
        Integer sum1 = numberStringList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println("sum1 = " + sum1);

        Integer sum2 = numberStringList.stream()
                .reduce(0,
                        (number, str) -> number + Integer.parseInt(str),
                        (num1, num2) -> num1 + num2);
        System.out.println("sum2 = " + sum2);
    }

    public void applyMethod() {
        AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
        List<User> userList = autoCreateDomain.createUserList();

        //친구들의 총 합 구하기
        Integer count = userList.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0,
                        (x, y) -> x + y);
        System.out.println("count = " + count);

        List<Order> orderLineList = autoCreateDomain.createOrderLineList();

        //List<Order> 안에 있는 orderLineList들의 Amount의 합
        BigDecimal sumOfAmount = orderLineList.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, (x, y) -> x.add(y));
        System.out.println("sumOfAmount = " + sumOfAmount);

        BigDecimal sumOfAmount1 = orderLineList.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("sumOfAmount1 = " + sumOfAmount1);


    }


}
