# Michael Blackburn
# sphereFunctions.py

import math

def sphereArea(radius):
    area = 4 * math.pi * (radius **2)
    return area

def sphereVolume(radius):
    volume = (4/3) * math.pi * (radius ** 3)
    return volume

def main():
    rad = eval(input("Enter the radius: "))
    a = sphereArea(rad)
    v = sphereVolume(rad)

    print("The surface area is:", str(round(a, 2)))
    print("The volume is:", str(round(v, 2)))

main()
