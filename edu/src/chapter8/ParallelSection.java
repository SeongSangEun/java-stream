package chapter8;

import chapter6.domain.AutoCreateDomain;
import chapter6.domain.User;
import service.EmailService;

import java.util.List;

public class ParallelSection {
    AutoCreateDomain autoCreateDomain = new AutoCreateDomain();
    EmailService emailService = new EmailService();

    public void sendEmailForEach() {
        List<User> userList = autoCreateDomain.createUserList();

        long start = System.currentTimeMillis();
        userList.stream().filter(u -> !u.isVerified())
                .forEach(u -> emailService.sendVerifiedEmail(u));
        long end = System.currentTimeMillis();

        System.out.println("소요 시각 = " + (end-start) + " ms");
    }
    public void sendEmailParallel() {
        List<User> userList = autoCreateDomain.createUserList();

        long start = System.currentTimeMillis();
        userList.stream().parallel()
                .filter(u -> !u.isVerified())
                .forEach(u -> emailService.sendVerifiedEmail(u));
        long end = System.currentTimeMillis();

        System.out.println("소요 시각 = " + (end-start) + " ms");


    }


}
