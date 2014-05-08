## pi.py
## Michael Blackburn

def main():
    num = eval( input("Enter the number of terms: "))
    product = 1
    for i in range (1, num+1):
        n = ((1 + i) // 2) * 2
        d = (((((i + 1) + 1) // 2) - 1) * 2) + 1
        product = (n / d) * product

    approx = product * 2    
    print("The approximation of pi for ",num, " is " ,approx)

main()
