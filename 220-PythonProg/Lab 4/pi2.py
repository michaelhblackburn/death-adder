## Michael Blackburn
## pi2.py

import math

def main():
    num = 4
    n = -1
    total = 0
    den = 1
    numTerms = eval(input("Input the number of terms to evaluate: "))
    for i in range(numTerms):
        n = n * -1
        quot = (num / den) * n
        total = total + quot
        den = den + 2

    final = total - math.pi
    print("final = ", final)

main()
        
