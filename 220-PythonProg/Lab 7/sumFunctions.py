# Michael Blackburn
# sumFunctions.py

def sumN(n):
    sumN = 1
    for i in range(1, n):
        sumN = i + 1 + sumN
    return sumN
def sumNCubes(n):
    sumNcube = 1
    for i in range(1, n):
        sumNcube = (i +1) ** 3 + sumNcube
    return sumNcube

def main():
    num = eval(input("Enter a natural number: "))
    Sum = sumN(num)
    cubes = sumNCubes(num)
    print("The total is:", str(Sum))
    print("The cube total is:", str(cubes))

main()
