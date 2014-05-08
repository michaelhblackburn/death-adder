def main():
    fname = input("Enter filename: ")
    infile = open(fname, "r")

    longest_word = ""
    for line in infile:
        # process a line
        word = line.rstrip()
        if len(word) > len(longest_word):
            longest_word = word
            print(word)

    print("The longest word is " + longest_word)
    
    infile.close()

main()
