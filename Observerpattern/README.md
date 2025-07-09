# Observer Design Pattern Example: YouTube Notifications

This project is a simple, clear demonstration of the **Observer Design Pattern** using a familiar analogy: a YouTube channel and its subscribers.

## What is the Observer Pattern?

The Observer Pattern lets an object (the "Subject") maintain a list of its dependents (the "Observers") and notify them automatically of any state changes.

-   **The Subject:** The object being watched (e.g., a YouTube Channel).
-   **The Observers:** The objects that want to be notified (e.g., your phone, the app).

When the YouTube channel uploads a new video, it sends a notification to all its subscribers without needing to know what each subscriber will do with that information.

## How the Code Works

This project is split into four key files:

1.  **`interfaces.py`**: Defines the "contracts" or abstract base classes (`Subject`, `Observer`). This ensures that any new subject or observer we create will follow the rules of the pattern.

2.  **`subjects.py`**: Contains the `YouTubeChannel` class. This is our concrete **Subject**. It has a name, keeps a list of its subscribers, and notifies them when a new video is added.

3.  **`observers.py`**: Contains the `PhoneNotifier` and `AppNotifier` classes. These are our concrete **Observers**. Each one has a unique `update()` method that defines how it reacts to a notification.

4.  **`main.py`**: This is the entry point of the application. It creates the channel and observer objects and simulates the process of subscribing and receiving notifications.

## How to Run the Project

1.  Make sure all four files (`interfaces.py`, `subjects.py`, `observers.py`, `main.py`) are in the same directory.
2.  Open your terminal or command prompt.
3.  Navigate to the directory where you saved the files.
4.  Run the following command:

    ```sh
    python main.py
    ```

    (You may need to use `python3` depending on your system setup).

You will see output showing the channels being created, observers subscribing, and notifications being sent when a new video is "uploaded."
