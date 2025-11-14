from collections import defaultdict
from datetime import datetime
import logging

# 🔹 Configure logging
logging.basicConfig(level=logging.WARNING, format="%(levelname)s: %(message)s")


def parse_time_safe(time_str):
    """Safely parse time string to datetime object."""
    try:
        return datetime.strptime(time_str, "%Y-%m-%d %H:%M")
    
    except (ValueError, TypeError):
        logging.warning(f"Invalid timestamp skipped: {time_str}")
        return None


def calculate_device_on_time(logs, summary_type="total"):
    """
    Calculate ON time for each device.
    summary_type can be:
        - "total" → total minutes ON for all data
        - "daily" → breakdown by date
        - "hourly" → breakdown by hour
    """

    # Step 1️⃣: Group valid events by device
    device_events = defaultdict(list)

    for entry in logs:
        device = entry.get("device")
        time_str = entry.get("time")
        state = entry.get("state")

        time = parse_time_safe(time_str)
        if not (device and state and time):
            continue  # Skip incomplete or invalid entries

        device_events[device].append({"time": time, "state": state})
    # print(device_events)
    # Step 2️⃣: Sort events by time for each device
    for device in device_events:
        device_events[device].sort(key=lambda e: e["time"])
    # print(device_events)
    # Step 3️⃣: Compute ON durations
    total_on_time = defaultdict(lambda: defaultdict(float) if summary_type != "total" else 0)
    # {"D1": {"2025-11-01": 90.0}, "D2": {"2025-11-01": 45.0}}
    # print(total_on_time)

    for device, events in device_events.items():
        on_time = None

        for event in events:
            if event["state"] == "ON":
                on_time = event["time"]

            elif event["state"] == "OFF" and on_time:
                duration = (event["time"] - on_time).total_seconds() / 60  # in minutes

                # Add to correct category based on summary type
                if summary_type == "daily":
                    date_key = on_time.date().isoformat()
                    total_on_time[device][date_key] += duration

                elif summary_type == "hourly":
                    hour_key = on_time.strftime("%Y-%m-%d %H:00")
                    total_on_time[device][hour_key] += duration

                else:  # total
                    total_on_time[device] += duration

                on_time = None  # reset for next cycle

    return dict(total_on_time)
logs = [
    {"device": "D1", "state": "ON", "time": "2025-11-01 09:00"},
    {"device": "D1", "state": "OFF", "time": "2025-11-01 09:30"},
    {"device": "D2", "state": "ON", "time": "2025-11-02 01:00"},
    {"device": "D2", "state": "OFF", "time": "2025-11-03 03:00"},
    {"device": "D1", "state": "ON", "time": "2025-11-01 10:00"},
    {"device": "D1", "state": "OFF", "time": "2025-11-01 11:00"},
]
print(calculate_device_on_time(logs, summary_type="total"))
print(calculate_device_on_time(logs, summary_type="daily"))
print(calculate_device_on_time(logs, summary_type="hourly"))