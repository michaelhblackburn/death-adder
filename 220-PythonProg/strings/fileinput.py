def main():
    fname = input("Enter filename: ")
    infile = open(fname, "r")

    word_count = 0
    for line in infile:
        # process a line
        #word = line.rstrip()
        word_count = word_count + 1
        #print(word)

    print("Number of words is " + str(word_count))
   
    infile.close()

main()
