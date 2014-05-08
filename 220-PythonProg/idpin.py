def main():
    idNum = input("Enter the id number: ")
    pin = input("Enter the pin number: ")
    count = 1
    if idNum != "98765432":
        print("Unknown user")
    elif pin != "012345":
        while pin != "012345" and count < 3:
            print("wrong pin")
            pin = input("Enter the pin number: ")
            count += 1
          
        if count == 3 and pin != "012345":
            print("you have been logged off.")
        else:
            print("welcome")
    else:
        print("welcome")
        
main()
