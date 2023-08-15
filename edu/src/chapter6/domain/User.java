package chapter6.domain;

import java.util.List;
import java.util.Optional;

public class User {

    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    private List<Integer> friendUserIds;

    //setter Return 타입이 객체인 이유 : Stream chaining 을 하기 위함!
    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Optional<String> getOptionalEmailAddress() {
        return Optional.ofNullable(emailAddress);
    }

    public User setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;

    }

    public boolean isVerified() {
        return isVerified;
    }

    public User setVerified(boolean verified) {
        isVerified = verified;
        return this;

    }

    public List<Integer> getFriendUserIds() {
        return friendUserIds;
    }

    public User setFriendUserIds(List<Integer> friendUserIds) {
        this.friendUserIds = friendUserIds;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isVerified=" + isVerified +
                ", friendUserIds=" + friendUserIds +
                '}';
    }
}
