from logger_base import Logger

class FileLogger(Logger):
    def write(self, message):
        print(f"File::Logger: {message}")
