# numDigits.py
# Michael Blackburn

def main():
    num = eval(input("Enter a positive integer: "))
    while num > 0:
        numDigits = 0
        quo = num 
        while quo > 0:
            numDigits += 1
            quo = quo // 10
        print("Number of digits:", numDigits)
        num = eval(input("Enter a positive integer: "))

main()
