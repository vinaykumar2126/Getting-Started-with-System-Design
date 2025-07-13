from logger_base import Logger

class ErrorLogger(Logger):
    def write(self, message):
        print(f"Error Console::Logger: {message}")
