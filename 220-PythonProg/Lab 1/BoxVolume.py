## BoxVolume.py
## Michael Blackburn
## This program calculates the volume of a box

def main():
    length = eval(input("Enter the length: "))
    width = eval(input("Enter the width: "))
    height = eval(input("Enter the height: "))
    volume = length * width * height
    print("Volume =", volume)

main()
