from collections import defaultdict
from datetime import datetime

def compute_longest_streak(activity, max_gap_minutes=60):
    """
    Computes the longest consecutive active streak per user.
    Two events belong to the same streak if they occur within `max_gap_minutes`.
    """
    # Helper to parse datetime strings
    def parse_time(ts):
        try:
            return datetime.strptime(ts, "%Y-%m-%d %H:%M")
        except (ValueError, TypeError):
            return None

    # 1️⃣ Group events by user
    user_times = defaultdict(list)
    for event in activity:
        user = event.get("user")
        ts = event.get("time")
        if not user or not ts:
            continue
        user_times[user].append(parse_time(ts))

    # 2️⃣ Compute longest streak per user
    result = {}
    for user, times in user_times.items():
        if not times:
            result[user] = 0
            continue

        # Sort chronologically
        times.sort()
        longest = 1
        current_streak = 1

        # Compare consecutive times
        for i in range(1, len(times)):
            delta = (times[i] - times[i - 1]).total_seconds() / 60
            if delta <= max_gap_minutes:
                current_streak += 1
            else:
                longest = max(longest, current_streak)
                current_streak = 1  # reset streak

        longest = max(longest, current_streak)
        result[user] = longest

    return result


# 🧪 Example usage
activity = [
    {"user": "A", "time": "2025-11-01 09:00"},
    {"user": "A", "time": "2025-11-01 09:45"},
    {"user": "A", "time": "2025-11-01 11:10"},  # gap > 1 hr → new streak
    {"user": "B", "time": "2025-11-01 09:15"},
    {"user": "B", "time": "2025-11-01 09:55"},
]

print(compute_longest_streak(activity))
