## Michael Blackburn, CSCI 220
## weightedAverage.py
## This program was completed by the author, with no outside assistance given.

## The goal of this program is to open a file that contains student names, grades, and the weight
## given to those grades. Students in this problem may take a different number of tests, and
## as such, have different weights assigned to those grades by the instructor. The program reads
## those student names, weights, and grades, then calculates the appropriate grades by
## multiplying each grade by its weight, adding the results together, then dividing that result by
## 100. The program then reports each student's average, then calculates the class average by
## adding each student's average and dividing the result by the number of students in the class.

def main():
    # enter a file name to read
    fileName = input("Enter a file name: ")
    # open the file as a read only file
    infile = open(fileName, "r")
    # initialize the class total variable and record count variable to 0
    total = 0
    recordCount = 0
    # enter loop to prcess the records in the file
    for line in infile:
        # strip white space from the right side of each line
        record = line.rstrip()
        # increment the record count by 1
        recordCount = recordCount + 1
        # split each record into a list of entries
        entries = record.split()
        # initalize a number variable to 2 and the student's total variable to 0
        n = 2
        studentTotal = 0
        # enter a loop to calculate each grade by weight
        for i in range(2, len(entries), 2):
            # multiplies each grade by weight and adds that to the student's total
            studentTotal = studentTotal + (eval(entries[n]) * eval(entries[n+1]))
            # increment the number variable by 2
            n = n + 2
            
        # calculates the student's average by dividing the total weighted scores by 100                
        studentAverage = studentTotal / 100
        # adds the student's average to the class total
        total = total + studentAverage            
        # prints the student's name and average, formatted to one decimal place           
        print(entries[0], entries[1],"'s average: ", round(studentAverage, 1))
    # blank line
    print()
    # calculates the class average by dividing the class total by the number of records
    classAverage = total / recordCount
    # prints the class average, formatted to one decimal place
    print("Class average: ",round(classAverage, 1))
    # closes the file
    infile.close()

main()
