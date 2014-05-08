def main():
    fname = input("Enter filename: ")
    infile = open(fname, "r")

    word_count = 0
    for line in infile:
        # process a line
        word_count = word_count + 1

    print("There are " + str(word_count) + " words in the file")

    infile.close()

main()
