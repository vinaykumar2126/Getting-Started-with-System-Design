from datetime import datetime

def parse_date(date_string):
    return datetime.strptime(date_string, "%Y-%m-%dT%H:%M:%SZ")

def create_party_windows(party_submission_data, geographic_data):
    # 1) Build lookup: party_id -> neighborhood
    party_to_neighborhood = {}
    for geo in geographic_data["geo_data"]:
        party_id = geo["party_id"]
        neighborhood = geo["neighborhood"]
        party_to_neighborhood[party_id] = neighborhood

    # 2) Track min start / max end per neighborhood (using datetimes)
    windows = {}  # { neighborhood: {"start": datetime, "end": datetime} }

    for entry in party_submission_data["submissionData"]:
        party_id = entry["party_id"]
        # skip if we don't know where this party is
        if party_id not in party_to_neighborhood:
            continue

        neighborhood = party_to_neighborhood[party_id]
        start = parse_date(entry["start_time"])
        end = parse_date(entry["end_time"])

        if neighborhood not in windows:
            windows[neighborhood] = {"start": start, "end": end}
        else:
            if start < windows[neighborhood]["start"]:
                windows[neighborhood]["start"] = start
            if end > windows[neighborhood]["end"]:
                windows[neighborhood]["end"] = end
    print(windows)
    # 3) Convert to the required output format (hours only)
    result = {}
    for neighborhood, window in windows.items():
        result[neighborhood] = {
            "start_hour": window["start"].hour,
            "end_hour": window["end"].hour,
        }
    # print(result)

    return result

party_submission_data = {
    "submissionData": [
        {
            "start_time": "2024-11-04T06:00:00Z",
            "end_time":   "2024-11-04T11:00:00Z",
            "party_id":   "0j1k2l",
        },
        {
            "start_time": "2024-11-05T14:00:00Z",
            "end_time":   "2024-11-05T18:30:00Z",
            "party_id":   "3m4n5o",
        },
    ]
}

geographic_data = {
    "geo_data": [
        {
            "state":        "NY",
            "city":         "New York",
            "town":         "Queens",
            "neighborhood": "Astoria",
            "party_id":     "0j1k2l",
        },
        {
            "state":        "NY",
            "city":         "New York",
            "town":         "Queens",
            "neighborhood": "Astoria",
            "party_id":     "3m4n5o",
        },
        {
            "state":        "NY",
            "city":         "New York",
            "town":         "Brooklyn",
            "neighborhood": "Williamsburg",
            "party_id":     "p_williamsburg_1",
        },
    ]
}
party_windows = create_party_windows(party_submission_data, geographic_data)
print(party_windows)

# start_time_str = party_submission_data["submissionData"][0]["start_time"]
# start2_time_str = party_submission_data["submissionData"][1]["start_time"]
# print(start_time_str)  # 2024-11-04T06:00:00Z
# print(start2_time_str)  # 2024-11-05T14:00:00Z

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
# print(dt.total_seconds()) # AttributeError: 'datetime.datetime' object has no attribute 'total_seconds'

# hashmap = [{"keyy1":3}]
# print(hashmap[0]["keyy1"])