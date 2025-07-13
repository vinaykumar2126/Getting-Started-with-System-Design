from error_logger import ErrorLogger
from file_logger import FileLogger
from console_logger import ConsoleLogger
from log_levels import INFO, DEBUG, ERROR

def get_logger_chain():
    # Create loggers
    error_logger = ErrorLogger(ERROR)
    file_logger = FileLogger(DEBUG)
    console_logger = ConsoleLogger(INFO)

    # Build chain: error -> file -> console
    error_logger.set_next(file_logger)
    file_logger.set_next(console_logger)

    return error_logger
