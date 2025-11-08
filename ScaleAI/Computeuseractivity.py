from datetime import datetime
from collections import defaultdict

def compute_total_active_time(sessions):
    """
    Computes total active time per user (in minutes)
    Handles overlapping sessions and invalid timestamps.
    """
    
    def parse_time(time_str):
        """Safely convert string to datetime. Returns None if invalid."""
        try:
            return datetime.strptime(time_str, "%Y-%m-%d %H:%M")
        except (ValueError, TypeError):
            return None
    
    # Step 1: Group sessions by user
    user_sessions = defaultdict(list)
    for session in sessions:
        user = session.get("user")
        start = parse_time(session.get("start"))
        end = parse_time(session.get("end"))
        
        # Skip invalid or incomplete sessions
        if not user or not start or not end or end <= start:
            print(f"⚠️ Skipping invalid session: {session}")
            continue
        
        user_sessions[user].append((start, end))
        print(start, end)
    
    # Step 2: Merge overlapping intervals for each user
    user_totals = {}
    for user, intervals in user_sessions.items():  #When comparing tuples of datetimes datetime comparison works directly
        if not intervals:
            user_totals[user] = 0
            continue
        print(intervals)
        # Sort by start time
        intervals.sort(key=lambda x: x[0])
        merged = [intervals[0]]
        
        for current_start, current_end in intervals[1:]:
            last_start, last_end = merged[-1]
            ## Python internally converts to timestamps and compares
            if current_start <= last_end:  # overlap or touch # Then: 1730440500.0 < 1730445000.0 → True
                merged[-1] = (last_start, max(last_end, current_end))
            else:
                merged.append((current_start, current_end))
        
        # Step 3: Compute total minutes
        total_minutes = sum((end - start).total_seconds() / 60 for start, end in merged)
        user_totals[user] = total_minutes
    
    return user_totals


# Example usage:
data = [
    {"user": "Alice", "start": "2025-11-01 09:00", "end": "2025-11-01 10:30"},
    {"user": "Alice", "start": "2025-11-01 10:00", "end": "2025-11-01 11:00"},  # overlap with previous
    {"user": "Bob",   "start": "2025-11-01 09:15", "end": "2025-11-01 09:45"},
    {"user": "Bob",   "start": "2025-11-01 10:00", "end": "2025-11-01 11:00"},
    {"user": "Charlie", "start": "2025-11-01 09:30", "end": "INVALID_TIME"},     # invalid end
    {"user": "Diana", "start": "2025-11-01 12:00", "end": "2025-11-01 11:00"},   # invalid interval
]

result = compute_total_active_time(data)
print(result)


#Time and space complexity analysis:
#Time Complexity: Time Complexity: O(n + m log m)
# Where:

# n = total number of sessions (all users combined)
# m = maximum number of sessions for any single user

# Sort per user	O(m log m)	Sort m sessions per user

# Space Complexity: O(n)
# Storing sessions per user	O(n) - All sessions stored in user_sessions as tuples
# user_totals = {}  # ← O(k) where k = number of users
# Usually k << n, so negligible