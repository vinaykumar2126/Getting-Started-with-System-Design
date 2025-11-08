# Outliers are data points that are way different from the rest of the data.
# values that are unusually high or low compared to most other values.
# They “stand out” from the crowd → out-liers.

## Any value more than 1.5x or 2x standard deviations away from the mean is an outlier.
data = [
    {"user": "Alice", "score": 50},
    {"user": "Alice", "score": 52},
    {"user": "Alice", "score": 90},  # outlier
    {"user": "Bob", "score": 60},
    {"user": "Bob", "score": 61},
    {"user": "Bob", "score": 59},
]

from collections import defaultdict
import statistics

def detect_outliers(data):
    """Detect outlier scores per user using standard deviation method."""
    
    user_scores = defaultdict(list)

    # Group scores by user, skip invalid entries
    for entry in data:
        user = entry.get("user")
        score = entry.get("score")
        if not user or not isinstance(score, (int, float)):
            continue
        user_scores[user].append(score)

    summary = {}
    for user, scores in user_scores.items():
        if len(scores) < 2:
            summary[user] = {"outliers": []}
            continue
        
        mean = statistics.mean(scores)
        sd = statistics.stdev(scores)
        threshold = 1 * sd

        outliers = [s for s in scores if abs(s - mean) > threshold]
        summary[user] = {"outliers": outliers}
    
    return summary
result = detect_outliers(data)
print(result)