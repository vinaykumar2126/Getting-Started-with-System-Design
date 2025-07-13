from abc import ABC, abstractmethod

class Logger(ABC):
    def __init__(self, level):
        self.level = level
        self.next_logger = None

    def set_next(self, next_logger):
        self.next_logger = next_logger

    def log_message(self, level, message):
        if self.level <= level:
            self.write(message)
        if self.next_logger:
            self.next_logger.log_message(level, message)

    @abstractmethod
    def write(self, message):
        pass
