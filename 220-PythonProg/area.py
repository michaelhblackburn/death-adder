import math

def main():
    h = eval(input("enter the height: ")) 
    r = eval(input("enter the radius: "))
    A = 2*(math.pi*(r**2)) + 2*(math.pi*(r*h))
    print("the area equals ", A)

main()
