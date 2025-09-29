package Notification_System;

public class Main {
    public static void main(String args[]){
        // MobileNotification Mn = new MobileNotification();
        // Mn.sendNotification("hi there");
        NotificationsHandler handler = new NotificationsHandler(new EmailNotification());
        handler.notify("This is an email notification");
        handler = new NotificationsHandler(new MobileNotification());
        handler.notify("This is a mobile notification");
    }
    
}
