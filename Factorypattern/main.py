from factory import JuiceFactory

def main():
    factory = JuiceFactory()

    juice1 = factory.get_juice("mango")
    if juice1:
        juice1.serve()

    juice2 = factory.get_juice("apple")
    if juice2:
        juice2.serve()

    juice3 = factory.get_juice("banana")
    if juice3:
        juice3.serve()
    else:
        print("Unknown juice type")

if __name__ == "__main__":
    main()
