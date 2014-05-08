## encode.py
## Michael Blackburn and Ian Mathies

def main():
    sent = input("Enter a sentence: ")
    n = eval(input("Enter number of keys: "))
    words = sent.split()
    Lnew = ""
    for word in words:
        
        for character in word:
            Lnew = Lnew + str(chr(ord(character)+n))
        Lnew = Lnew + " "
    print(Lnew)

main()
