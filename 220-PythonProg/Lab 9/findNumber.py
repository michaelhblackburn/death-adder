# findNumber.py
# Michael Blackburn

def main():
    numList = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    num = eval(input("Enter a number to find whether it is in the list: "))
    found = False
    i = 0
    while i <= (len(numList)-1) and found == False:
        if num == numList[i]:
            print("Number found at list position", i)
            found = True
        else:
            i += 1
            
     if found == False:
        print("The number is not in the list. ")

main()
            
