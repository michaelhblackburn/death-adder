def main():
    fname = input("Enter filename: ")
    infile = open(fname, "r")

    ious_word_count = 0
    for line in infile:
        # process a line
        word = line.rstrip()   # remove white space at end of line
        if word[:5] == "antid":
            print(word)
            ious_word_count = ious_word_count + 1

    print("There were " + str(ious_word_count) + " ious words in the file")
    
    infile.close()

main()
