#Naive vs Aware Datetimes
# Naive(Ambiguous) is with no time zone info
# Aware is with time zone info
from datetime import datetime, timezone

dt = datetime(2025, 11, 6, 14, 30, tzinfo=timezone.utc)  # Aware datetime with UTC timezone
print(dt)  # 2025-11-06 14:30:00+00:00
dt = datetime(2025, 11, 6, 14, 30)  # Naive datetime because No timezone info provided
print(dt)  # 2025-11-06 14:30:00

print(dt.date()) # 2025-11-06
print(dt.time()) # 14:30:00
print(dt.timetuple()) # It returns a named tuple representing the date and time components
print(dt.year) # 2025
print(dt.total_seconds()) # AttributeError: 'datetime.datetime' object has no attribute 'total_seconds'
