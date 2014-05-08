def isEqual(num1, num2):
    if abs(num1 - num2) <= .0000001:
        return True
    else:
        return False

def main():
    num1= eval(input("enter number 1: "))
    num2 = eval(input("enter number 2: "))
    boolean = isEqual(num1, num2)
    print(boolean)

main()
