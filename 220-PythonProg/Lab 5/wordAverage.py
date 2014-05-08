## Michael Blackburn
## wordAverage.py

def main():
    sentence = input("Enter a sentence for averaging: ")
    words = sentence.split()
    count = 0
    for i in words:
        count = count + len(i)

    average = count / len(words)
    print(average)

main()
