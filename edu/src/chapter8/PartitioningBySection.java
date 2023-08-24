package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.User;
import service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBySection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();

    //두 그룹으로 나눌때 사용
    public void integerPartition() {
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 502, 502, 1213, 1231230, 258, 111);

        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("numberPartitions = " + numberPartitions);

    }

    public void userPartition() {
        //친구숫자가 3명 초과 Y, 이하 N

        List<User> userList = autoCreateDomain.createUserList();
        Map<Boolean, List<User>> userPartitionsMap = userList.stream().collect(Collectors.partitioningBy(u -> u.getFriendUserIds().size() > 3));
        System.out.println("userPartitionsMap = " + userPartitionsMap);

        EmailService emailService = new EmailService();
        userPartitionsMap.get(true).forEach(
                u -> emailService.sendPlayWithFriendsEmail(u)
        );
        userPartitionsMap.get(false).forEach(
                u -> emailService.sendMakeMoreFriendsEmail(u)
        );


    }
}
