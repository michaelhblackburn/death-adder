## Michael Blackburn
## initials.py

def main():
    num = eval(input("Enter the number of names to be input: "))
    for i in range(num):
        firstName = input("Enter the student's first name: ")
        lastName = input("Enter "+str(firstName)+"'s last name: ")
        print(str(firstName)+"'s initials are:"+str(firstName[0]) + str(lastName[0]))

main()

        
