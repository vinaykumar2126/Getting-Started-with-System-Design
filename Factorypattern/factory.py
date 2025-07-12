from mango import MangoJuice
from apple import AppleJuice

class JuiceFactory:
    def get_juice(self, juice_type):
        if juice_type.lower() == "mango":
            return MangoJuice()
        elif juice_type.lower() == "apple":
            return AppleJuice()
        else:
            return None
