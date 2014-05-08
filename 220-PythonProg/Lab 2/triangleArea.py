## triangleArea.py
## Michael Blackburn

import math
def main():
        a = eval (input ("Please enter the length of the a side: "))
        b = eval( input ("Please enter the length of the b side: "))
        c = eval (input ("Please enter the length of the c side: "))
        while (a > 0, b > 0, c > 0):
            s = (a + b + c) / 2
            area = math.sqrt(s* (s - a) * (s - b) * (s - c))
            print("The area of the triange is ", area)
            a = eval (input ("Please enter the length of the a side: "))
            b = eval( input ("Please enter the length of the b side: "))
            c = eval (input ("Please enter the length of the c side: "))
        
main()
