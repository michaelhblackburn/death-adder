## Michael Blackburn
## wordCount.py

def main():
    sentence = input("Enter a sentence to count the words in: ")
    words = sentence.split()
    print("The number of words in the sentence is: ",len(words))

main()
