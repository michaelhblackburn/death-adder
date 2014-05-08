# Code compares runtimes of insertion sort and Python's built-in sort
# Author: RoxAnn H. Stalvey

from algorithms import *
from random import randint
import time

def main():
    print("Code to look at runtime for insertion sort vs. Python's list sort.")
    
    numDig = 5 #number of digits to output
    
    #large list with numElements elements
    numElements = 10000
    data = []
    for i in range(numElements):
        data.append(randint(1, numElements))
        
    print("\nSorting list with " + str(len(data)) + " elements.\n")
    
    start = time.time()
    insertionSort(data)
    end = time.time()
    print("Insertion sort -> " + str(round(end - start, numDig)) + " seconds.")

    #large list with numElements elements
    numElements = 10000
    data = []
    for i in range(numElements):
        data.append(randint(1, numElements))
        
    start = time.time()
    data.sort()
    end = time.time()
    print("Python's sort -> " + str(round(end - start, numDig)) + " seconds.")

main()
