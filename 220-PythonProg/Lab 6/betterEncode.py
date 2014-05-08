## betterEncode.py
## Michael Blackburn and Ian Mathies

def main():
    sent = input("Enter a sentence: ")
    n = eval(input("Enter number of keys: "))
    words = sent.split()
    Lnew = ""
    for word in words:
        
        for character in word:
            r =chr( (ord(character) - 97 + n) % 26 +97)
            Lnew = Lnew +(r)
        Lnew = Lnew + " "
    print(Lnew)

main()
