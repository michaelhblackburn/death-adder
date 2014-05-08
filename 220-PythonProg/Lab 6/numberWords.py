# numberWords.py
# Michael Blackburn and Ian Mathies

def main():
    fileName = input("Enter a file name to read: ")
    outFileName = input("Enter a file to write to: ")
    infile = open(fileName, "r")
    outfile = open(outFileName, "w")
    n= 1
    for line in infile:
        entries = line.split()
        r = 0
        for i in range(len(entries)):
            print(str(n)+"."+ entries[r], file=outfile)
            n = n+1
            r = r+1
            

    infile.close()
    outfile.close()
main()
    
    
