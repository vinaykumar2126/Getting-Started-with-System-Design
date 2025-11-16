#Compute Standard Deviation
scores = [
    {"user": "A", "score": 10},
    {"user": "A", "score": 20},
    {"user": "A", "score": 30},
    {"user": "B", "score": 50},
    {"user": "B", "score": 50},
]
from collections import defaultdict
import statistics
def compute_user_stddevs(scores):
    def is_valid_score(score):
        return score["user"] and isinstance(score["score"], (float, int))

    user_scores = defaultdict(list)
    for score in scores:
        if not is_valid_score(score):
            continue
        user = score["user"]
        score = score["score"]
        user_scores[user].append(score)
    summary = {}
    for user,scores in user_scores.items():
        sd = statistics.stdev(scores) if len(scores) > 1 else 0.0  # O(m)
        r = max(scores)-min(scores)  # O(m)
        summary[user] = {"stddev": sd, "range": r}
    return summary
result = compute_user_stddevs(scores)
print(result) # {'A': {'stddev': 10.0, 'range': 20}, 'B': {'stddev': 0.0, 'range': 0}}

hashmap = {"name": "ScaleAI", "type": "AI Company", "founded": 2016}
print(hashmap.pop("type"))  # Output: AI Company
print(hashmap)  # Output: {'name': 'ScaleAI', 'founded': 2016}