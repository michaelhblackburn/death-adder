# algorithms.py
# Michael Blackburn

# In the smaller list, the linear search and binary search both return results fairly quickly, with
# consistent search times for each type of search. The binary search returns results slightly
# faster, with a search time of .00001 seconds for each value, versus .00002 seconds for the
# linear search. In the list with more entries, we see a significant increase the amount of time it
# takes to get results with the linear search, versus continued quick results with the binary
# search. Iterating through the list, the linear sees inconsistent times greater than 1 second,
# versus a consistent .00003 seconds for results in the binary search. This is reflective of the
# difference in the two techniques, with binary reading far fewer values during its search than
# the linear search.

# The sort functions show vastly different efficiencies. Using the insertion sort written in class,
# times to sort a 100 item list is almost 20 seconds. Python's bulit in sort returns a sort in less
# one second, demonstraing the inefficiency of the insertion sort. 

def readData(filename):
    infile = open(filename, "r")
    dataList = []
    for line in infile:
        entries = line.split()
        for i in entries:
            dataList.append(eval(i))
    infile.close()
    return dataList

def isInLinear(srchVal, values):
    isTrue = False
    for i in range(len(values)):
        if srchVal == values[i]:
            isTrue = True
    return isTrue   

def isInBinary(srchVal, values):
    low = 0
    high = len(values) - 1
    while low <= high:
        mid = (low + high) // 2
        midItem = values[mid]
        if srchVal == midItem:
            return True
        elif srchVal < midItem:
            high = mid - 1
        else:
            low = mid + 1
    return False

def insertionSort(values):
    for i in range(1, len(values)):
        j = i
        while j != 0 and values[j] < values[j-1]:
                values[j], values[j-1] = values[j-1], values[j]
                j = j-1
    return values
    

def main():
    dataList = readData("dataSorted.txt")
    print(dataList)
    value = eval(input("Enter a value to search for in the list: "))
    isTrue = isInLinear(value, dataList)
    binTrue = isInBinary(value, dataList)
    if isTrue == True:
        print("The value is in the list.")
    else:
        print("The value was not found.")
    if binTrue == True:
        print("The value is in the list.")
    else:
        print("The value was not found.")
    numList = [4, 2, 3, 5, 1]
    sortList = insertionSort(numList)
    print(sortList)



main()
