# goodInput.py
# Michael Blackburn

def main():
    num = eval(input("Enter a number between 1 and 10: "))
    while num <1 or num > 10:
        print("That entry is not in the parameters.")
        num = eval(input("Enter a number between 1 and 10: "))
                   
    print("Number entered:", num)

main()
