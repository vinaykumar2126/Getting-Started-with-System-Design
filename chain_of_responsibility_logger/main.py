from client import get_logger_chain
from log_levels import INFO, DEBUG, ERROR

def main():
    logger_chain = get_logger_chain()

    print("Sending INFO level log:")
    logger_chain.log_message(INFO, "This is an INFO message.")

    print("\nSending DEBUG level log:")
    logger_chain.log_message(DEBUG, "This is a DEBUG message.")

    print("\nSending ERROR level log:")
    logger_chain.log_message(ERROR, "This is an ERROR message.")

if __name__ == "__main__":
    main()
