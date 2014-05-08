def short(phrase):
    phrase.upper()
    words = phrase.split()
    shorthand = ""
    for i in range(len(words)):
        shorthand = shorthand + words[i][0]
    print(shorthand.upper())

def main():
    phrase = input("Enter a phrase: ")
    short(phrase)

main()
