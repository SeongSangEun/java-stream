package chapter7;

import chapter6.domain.User;

import java.util.Optional;

public class OptionalSection {

    public void getOptionalCheck() {
        String someEmail = "some@test.co.kr";
        String nullEmail = null;

        Optional<String> maybeEmail1 = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String s = maybeEmail1.get();
        System.out.println("s = " + s);

        String defaultEmail =  "default@email.com";
        String nullEmail1 = maybeEmail2.orElse(defaultEmail);
        System.out.println("defaultEmail = " + nullEmail1);

        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println("email4 = " + email4);

        maybeEmail2.orElseThrow(
                () -> new RuntimeException("email not exist")
        );

    }


    public void whenOccurNPE() {
        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@test.co.kr");
        User user2 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true);
        boolean isEqual = userEquals(user1, user2);
        System.out.println("isEqual = " + isEqual);

    }

    private boolean userEquals(User user1, User user2) {
        return user1.getId() == user2.getId()
                && user1.getName().equals(user2.getName())
                && user1.getEmailAddress().equals(user2.getEmailAddress())
                && user1.isVerified() == user2.isVerified();
    }
}
