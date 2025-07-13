from logger_base import Logger

class ConsoleLogger(Logger):
    def write(self, message):
        print(f"Standard Console::Logger: {message}")
