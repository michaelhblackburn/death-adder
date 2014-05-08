## newton.py
##Michael Blackburn

def main():
    x = eval( input("Enter the number: "))
    times = eval( input("How many times would you like to improve the approximation: "))
    approx = x / 2
    for i in range(times):
        approx  = (approx + (x / approx)) / 2

    print("The number is: ", x)
    print("The final value is: " , approx)
    
main()
