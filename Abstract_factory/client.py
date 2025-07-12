def client_code(factory):
    chair = factory.create_chair()
    sofa = factory.create_sofa()

    chair.sit_on()
    sofa.lie_on()
