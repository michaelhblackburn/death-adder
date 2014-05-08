def main():
    fname = input("Enter filename: ")
    infile = open(fname, "r")

    longest_palindrome = ""
    for line in infile:
        # process a line
        word = line.rstrip()   # remove white space at end of line
        if word == word[::-1]: # compares word with reverse of word
            if len(word) > len(longest_palindrome):
                longest_palindrome = word
                print(longest_palindrome)
 
    print("The longest palindrome is " + longest_palindrome)
    
    infile.close()

main()
