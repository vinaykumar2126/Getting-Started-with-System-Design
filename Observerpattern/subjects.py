# subjects.py

from interfaces import Subject, Observer

class YouTubeChannel(Subject):
    """
    The concrete Subject owns the core state and notifies observers of changes.
    """
    _latest_video_title: str = None
    
    def __init__(self, channel_name: str):
        """Constructor to initialize the channel with a name and observer list."""
        self.name = channel_name
        self._observers: list[Observer] = []
        print(f"\n'{self.name}' channel has been created.")

    def register(self, observer: Observer):
        print(f"'{self.name}': A new observer has subscribed.")
        self._observers.append(observer)

    def unregister(self, observer: Observer):
        print(f"'{self.name}': An observer has unsubscribed.")
        self._observers.remove(observer)

    def notify(self):
        """Trigger an update in each subscriber."""
        print(f"'{self.name}': Notifying all observers...")
        for observer in self._observers:
            message = f"'{self.name}' uploaded '{self._latest_video_title}'"
            observer.update(message)

    def add_new_video(self, title: str):
        """A business logic method that triggers notifications."""
        print(f"\n'{self.name}': Uploading a new video titled '{title}'")
        self._latest_video_title = title
        self.notify()