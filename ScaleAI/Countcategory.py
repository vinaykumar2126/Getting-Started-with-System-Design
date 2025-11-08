events = [
    {"type": "click"},
    {"type": "scroll"},
    {"type": "click"},
    {"type": "click"},
    {"type": "hover"},
]

def count_event_types(events):
    result = {}
    for event in events:
        click = event.get("type")
        result[click] = result.get(click,0)+1
    return result
print(count_event_types(events))
