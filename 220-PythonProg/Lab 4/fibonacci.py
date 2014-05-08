## Michael Blackburn
## fibonacci.py

def main():
    f = 1
    n = 1
    num = eval(input("Enter the number of terms to evaluate: "))
    for i in range (1, num ):
        fib = f + n
        f = n
        n = fib
                
    print("The Fibonacci number is: ",f)

main()

        
        
        
    
