# main.py

from subjects import YouTubeChannel
from observers import PhoneNotifier, AppNotifier

if __name__ == "__main__":
    # --- Create subjects (channels) ---
    tech_channel = YouTubeChannel("Tech with Vinay")
    cook_channel = YouTubeChannel("Cooking with Vinay")

    # --- Create observers ---
    phone_sub = PhoneNotifier()
    app_sub = AppNotifier()

    # --- Register observers to the tech channel ---
    print("\n--- Registering to Tech Channel ---")
    tech_channel.register(phone_sub)
    tech_channel.register(app_sub)
    
    # --- Register observers to the cooking channel ---
    print("\n--- Registering to Cooking Channel ---")
    cook_channel.register(phone_sub) # The same phone observer subscribes here too

    # --- Trigger events ---
    tech_channel.add_new_video("Learning Design Patterns")
    cook_channel.add_new_video("How to Make Pizza")

    # --- Show unique observer behavior ---
    phone_sub.show_history()