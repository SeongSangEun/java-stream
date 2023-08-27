package service;

import chapter6.domain.User;

public class EmailService {

    public void sendPlayWithFriendsEmail(User user) {
        if(!user.getEmailAddress().isEmpty()) {
            System.out.println("Sending 'Play With Friends' email to ' = " + user.getEmailAddress());
        }
    }
    public void sendMakeMoreFriendsEmail(User user) {
        if(!user.getEmailAddress().isEmpty()) {
            System.out.println("Sending 'Make more Friends' email to ' = " + user.getEmailAddress());
        }
    }
    public void sendVerifiedEmail(User user) {
        if(!user.isVerified()) {
            System.out.println("Sending 'Please Email Verified' email to ' = " + user.getEmailAddress());
        }
    }
}
