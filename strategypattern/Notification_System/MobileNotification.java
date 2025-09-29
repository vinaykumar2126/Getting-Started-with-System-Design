package Notification_System;

public class MobileNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending mobile notification: " + message);
    }
    
}
