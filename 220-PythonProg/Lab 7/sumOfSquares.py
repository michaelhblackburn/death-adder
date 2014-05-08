# Michael Blackburn
# sumOfSquares.py

def squareEach(nums):
    numsList = []
    for i in range(len(nums)):
        numsList.append(nums[i] ** 2)
    return numsList

def sumList(nums):
    sums = 0
    for i in range(len(nums)):
        sums = sums + nums[i]
    return sums
        
def toNumbers(strList):
    for i in range(len(strList)):
        strList[i] = eval(strList[i])
        
def solve(strList):
    print(strList)
    toNumbers(strList)
    newList = squareEach(strList)
    listSum = sumList(newList)
    return listSum
    
    
def main():
    fileName = input("Enter a file name: ")
    infile = open(fileName, "r")
    record = infile.readlines()
    sums = solve(record)
    print(sums)
    
    #listNums = [1, 2, 3, 4]
    #stringList = ["1", "2", "3", "4"]
    #squares  = squareEach(listNums)
    #total = sumList(listNums)
    #toNumbers(stringList)
    #print(squares)
    #print(total)
    #print(stringList)

main()
    
 
