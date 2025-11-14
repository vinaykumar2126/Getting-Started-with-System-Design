from collections import defaultdict
from datetime import datetime
data = [
    {"user": "Alice", "start": "2025-11-01 09:00", "end": "2025-11-01 10:30"},
    {"user": "Bob",   "start": "2025-11-01 09:15", "end": "2025-11-01 09:45"},
    {"user": "Alice", "start": "2025-11-01 10:00", "end": "2025-11-01 12:15"},
    {"user": "Bob",   "start": "2025-11-01 10:00", "end": "2025-11-01 11:00"},
    {"user": "Charlie", "start": "2025-11-01 09:30", "end": "2025-11-01 10:00"},
]
# Calculate total active time per user
def UserActivityCalculator(session):
    def parse_data(entry):
                return datetime.strptime(entry, "%Y-%m-%d %H:%M")
    user_sessions=defaultdict(list)
    for entry in session:
        start = parse_data(entry["start"])
        end = parse_data(entry["end"])

        user_sessions[entry["user"]].append((start,end))
    user_totals = {}
    

    for user,intervals in user_sessions.items():
            merged = []
            intervals.sort()
            merged.append(intervals[0])
            for start,end in intervals[1:]:
                last_start,last_end = merged[-1]

                if start<=last_end:
                    merged[-1]=(last_start,max(last_end,end))
                else:
                    merged.append((start,end))

            duration = sum((end-start).total_seconds()/60 for start,end in merged)
            user_totals[user] = duration
    return user_totals
result = UserActivityCalculator(data)
print(result)
