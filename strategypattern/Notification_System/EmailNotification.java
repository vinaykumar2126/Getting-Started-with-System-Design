package Notification_System;

public class EmailNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email notification: " + message);
    }
    
}
