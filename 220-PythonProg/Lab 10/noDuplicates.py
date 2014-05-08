# noDuplicates.py
# Michael Blackburn

def createDuplicates(numList):
    for j in range(5):
        for i in range(len(numList)):
            numList.append(numList[i])
    return numList

def removeDuplicates(list):
    listLen = len(list)
    i = listLen - 1
    while i >= 0:
        nums = list.count(list[i])
        if nums > 1:
            list.pop(i)
        i = i - 1

def main():
    numList = [5, 4, 3, 2, 1]
    print(numList)
    print()
    newList  = createDuplicates(numList)
    print(newList)
    removeDuplicates(newList)
    print()
    print(newList)

main()
