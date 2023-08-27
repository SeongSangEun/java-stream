package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.User;
import service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
    EmailService emailService = new EmailService();
    public void numberForEach() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 3, 5);
        numbers.stream().forEach(
                n -> System.out.println("n = " + n)
        );
    }

    public void userForEach() {
        List<User> userList = autoCreateDomain.createUserList();

        userList.stream().filter(u -> !u.isVerified())
                .forEach(u -> emailService.sendVerifiedEmail(u));
    }

    public void indexForEach() {
        //향상된 For문의 경우 forEach를 통하여 쉽게 변환이 가능하나
        // 이전의 for문의 경우 위처럼 간단하게 사용이 불가능함
        List<User> userList = autoCreateDomain.createUserList();
        IntStream.range(0, userList.size()) //
                .forEach(i ->
                {
                    User user = userList.get(i);
                    System.out.println("user.getName() = " + user.getName() + " / index = " + i);
                });

    }

}
