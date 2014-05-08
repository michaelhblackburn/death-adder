# isbn.py
# Michael Blackburn

def main():
    ISBN = input("Input the 10-digit ISBN number: ")
    total = 0
    value = 10
    for i in range(len(ISBN)):
        total = total + eval(ISBN[i]) * value
        value = value -1

    modValue = total % 11
    if modValue == 0:
        print("The ISBN number is valid.")
    else:
        print("The ISBN number is not valid.")

main()
