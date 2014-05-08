# hourlyWages.py
# Michael Blackburn and Ian Mathies

def main():
    fileName = input("Enter a file name: ")
    outFileName = input("Enter a file to write to: ")
    infile = open(fileName, "r")
    outfile = open(outFileName, "w")
    newWage = 0
    for line in infile:
        entries = line.split()
        for i in range(len(entries)):
            newWage = eval(entries[2]) + 1.65
            hours = eval(entries[3])
            pay = newWage * hours
        print(entries[0]+" "+entries[1]+"'s pay: "+"${0:.2f}".format(pay), file=outfile)

main()
        
    
