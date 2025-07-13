# Chain of Responsibility Logger Example

This project demonstrates the **Chain of Responsibility Design Pattern** using a logger system implemented in Python.

Each logger in the chain handles log messages of certain levels (`INFO`, `DEBUG`, `ERROR`) and passes them along the chain so other loggers can also process them.

---

## 📂 Project Structure

chain_of_responsibility_logger/
│
├── log_levels.py # Constants for log levels
├── logger_base.py # Abstract base Logger class
├── console_logger.py # ConsoleLogger implementation
├── file_logger.py # FileLogger implementation
├── error_logger.py # ErrorLogger implementation
├── client.py # Builds the logger chain
└── main.py # Entry point to run the example


---

## 🚀 How It Works

1. **Log Levels:**
   - `INFO = 1`
   - `DEBUG = 2`
   - `ERROR = 3`

2. **Loggers:**
   - `ErrorLogger` handles errors (`ERROR` level).
   - `FileLogger` handles debug logs (`DEBUG` level).
   - `ConsoleLogger` handles info logs (`INFO` level).

3. **Chain of Responsibility:**
   - The loggers are linked in a chain:
     ```
     ErrorLogger → FileLogger → ConsoleLogger
     ```
   - When a message is logged, each logger compares its `self.level` with the message level.
   - If `self.level <= message level`, it writes the message.
   - Then it forwards the log to the next logger in the chain (if any).

---

## ✅ Example Output

When you run the program, you will see:

Sending INFO level log:
Standard Console::Logger: This is an INFO message.

Sending DEBUG level log:
File::Logger: This is a DEBUG message.
Standard Console::Logger: This is a DEBUG message.

Sending ERROR level log:
Error Console::Logger: This is an ERROR message.
File::Logger: This is an ERROR message.
Standard Console::Logger: This is an ERROR message.


---

## 🧠 Why Use Chain of Responsibility for Logging?

- You can **easily add or remove handlers** without changing the core logic.
- Each handler decides whether to process the log.
- Logs can be processed by **multiple handlers independently**.
- It’s more flexible and decoupled than using `if-else` statements everywhere.

---

## 🏃‍♂️ How to Run

1. Make sure you have Python installed (3.x).
2. Open a terminal in the project directory.
3. Run:
   ```bash
   python main.py
