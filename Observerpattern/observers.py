# observers.py

from interfaces import Observer

class PhoneNotifier(Observer):
    """A concrete Observer with its own state and methods."""
    def __init__(self):
        """Constructor to initialize a notification history list."""
        self._notification_history = []

    def update(self, message: str):
        """Reacts to an update by printing and storing the notification."""
        print(f"  -> Phone Notifier (Push): {message}")
        self._notification_history.append(message)
    
    def show_history(self):
        """A unique method for this observer to show its history."""
        print(f"\n--- Phone Notification History ---")
        for notification in self._notification_history:
            print(f"  - {notification}")
        print("--------------------------------")


class AppNotifier(Observer):
    """A simpler concrete Observer."""
    def update(self, message: str):
        """Reacts to an update by printing a message."""
        print(f"  -> App Notifier (Red Dot): {message}")