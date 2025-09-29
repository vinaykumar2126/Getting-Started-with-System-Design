package Notification_System;

public class NotificationsHandler {
    private NotificationStrategy strategy;
    public NotificationsHandler(NotificationStrategy strategy){
        this.strategy = strategy;
    }

    public void notify(String message){
        strategy.sendNotification(message);
    }
}
