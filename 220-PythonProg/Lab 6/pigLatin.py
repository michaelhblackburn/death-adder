# pigLatin.py
# Michael Blackburn and Ian Mathies

def main():
    sentence = input("Enter a sentence to translate: ")
    latin = sentence.rstrip()
    words = latin.split()
    n=0
    pigLatin = ""
    for i in range(len(words)):
        newWord = words[n][1:]+words[n][0]+"ay"
        n = n+1
        pigLatin = pigLatin +" "+ newWord.lower()
        
    print(pigLatin)
        

main()
