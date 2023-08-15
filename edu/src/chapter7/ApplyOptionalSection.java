package chapter7;

import chapter6.domain.User;

import java.util.Optional;

public class ApplyOptionalSection {

    public void applyOptionalMethod() {
        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(false));
        Optional<User> maybeUser1 = Optional.ofNullable(maybeGetUser(true));

        maybeUser.ifPresent( user -> System.out.println("user = " + user));
        maybeUser1.ifPresent( user -> System.out.println("user = " + user));

        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true)).map(User::getId);
        maybeId.ifPresent(id -> System.out.println("id = " + id));

        String uptUser = Optional.ofNullable(maybeGetUser(true))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println("name_is_empty = " + uptUser);
        String uptUser1 = Optional.ofNullable(maybeGetUser(false))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println("name_is_empty = " + uptUser1);

        Optional<Optional<String>> optionalStringOptional = Optional.ofNullable(maybeGetUser(false))
                .map(User::getOptionalEmailAddress);
        // ->
        Optional<String> stringOptional = Optional.ofNullable(maybeGetUser(false))
                .flatMap(User::getOptionalEmailAddress);  //flatMap을 활용하여 Optional<Optional<String>> -> Optional<String> 된것 확인
        stringOptional.ifPresent(System.out::println);
    }


    public User maybeGetUser(boolean returnUser) {

        if(returnUser) {
            return new User()
                    .setId(101)
                    .setName("Paul")
                    .setVerified(true)
                    .setEmailAddress("alice@test.co.kr");
        } else return null;

    }

}
