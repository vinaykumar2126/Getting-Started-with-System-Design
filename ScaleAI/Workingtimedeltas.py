from datetime import datetime,timedelta,timezone
import time

td1 = timedelta(days=7)
print(td1) # 7 days, 0:00:00
td2 = timedelta(minutes=60)
print(td2) # 1:00:00

# Combine multiple units
td3 = timedelta(days=2,hours = 3,minutes = 15,seconds = 30)
print(td3) # 2 days, 3:15:30

total_seconds = td3.total_seconds()
print(total_seconds) # 184530.0

#Use of negatives
td4 = timedelta(days=-1)
print(td4) # -1 day, 0:00:00

today = datetime(2025,11,6,7,57)
print(today) # 2025-11-06 07:57:00
td5=today-timedelta(days=3) #Most Common way
# or td5=today+timedelta(days=-3)
td6=today+timedelta(days=-3)
print(td6) # 2025-11-03 07:57:00

print(datetime.now(tz=timezone.utc))  # Current time in UTC

# Get current timestamp
timestamp = time.time()
print(f"Timestamp: {timestamp}") # 1762547763.028316

# Method 1: Using Python's built-in (easy)
dt = datetime.fromtimestamp(timestamp)
print(f"Built-in result: {dt}") # Built-in result: 2025-11-06 07:56:03.028316


date_string = "2025-11-06 14:30"
dt1 = datetime.strptime(date_string, "%Y-%m-%d %H:%M")
print(dt1)


dt5 = 1730907720
x = datetime.fromtimestamp(dt5)
print(type(x))
y = x.strftime("%Y-%m-%d %H:%M:%S")
print(type(y))  # <class 'str'>