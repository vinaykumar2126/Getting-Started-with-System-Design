from datetime import datetime
data = [
    {"user":"alice","start":"2025-11-03 09:00","end":"2025-11-03 10:30"},
    {"user":"bob","start":"2025-11-01 09:15","end":"2025-11-01 09:45"},
    {"user":"alice","start":"2025-11-03 09:25","end":"2025-11-03 11:45"}
]
# alice_times = [entry for entry in data if entry["user"]=="alice"]
# print(alice_times)
user_times = {}
for entry in data:
    start= datetime.strptime(entry["start"], "%Y-%m-%d %H:%M")
    end = datetime.strptime(entry["end"], "%Y-%m-%d %H:%M")

    duration_minutes = (end-start).total_seconds() / 60

    if entry["user"] not in user_times:
        user_times[entry["user"]] = int(duration_minutes)
    else:
        user_times[entry["user"]] += int(duration_minutes)

print(user_times)







# # print(alice_times[-1][11:])
# # latest_times = min(alice_times,key = lambda x: datetime.strptime(x["end"],"%Y-%m-%d %H:%M"))["end"]
# # latest_times = max(alice_times,key = lambda x: x["end"])["end"]
# # latest_times = max(alice_times, key=lambda x: x["end"].split()[1])["end"]

# # latest_times = max(alice_times,key=lambda x:datetime.strptime(x["end"],"%Y-%m-%d %H:%M"))["end"]
# latest_times = max(alice_times,key = lambda x: datetime.strptime(x["end"],"%Y-%m-%d %H:%M"))["end"]
# # print(latest_times)
# # dt = datetime.strptime(latest_times,"%Y-%m-%d %H:%M")
# # print(dt.time())
# # "2025-1-5" vs "2025-11-3" 



