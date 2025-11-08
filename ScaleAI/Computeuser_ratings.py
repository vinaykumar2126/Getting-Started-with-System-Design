ratings = [
    {"user": "Alice", "rating": 4},
    {"user": "Bob", "rating": 5},
    {"user": "Alice", "rating": 3},
    {"user": "Bob", "rating": 4},
    {"user": "Alice", "rating": 5},
    {"user": None, "rating": 4},   # invalid
]

from collections import defaultdict
import statistics

def compute_user_ratings(sessions):
    user_sessions = defaultdict(list)
    for session in sessions:
        if not session["user"]:
            continue
        user = session["user"]
        rating = session["rating"]

        user_sessions[user].append(rating)
    summary = {}
    for user,ratings in user_sessions.items():
        avg = sum(ratings) / len(ratings)
        median = statistics.median(ratings) #O(m log m) per group- sorts internally!
        maximum = max(ratings) # ← O(m)
        summary[user] = {"avg": avg, "median": median, "max": maximum}
    return summary

#Time Complexity: O(n + m log m)
#Space Complexity: O(n + k) k<<n


#Expected Output:
{
    "Alice": {"avg": 4.0, "median": 4, "max": 5},
    "Bob": {"avg": 4.5, "median": 4.5, "max": 5}
}
result = compute_user_ratings(ratings)
print(result)