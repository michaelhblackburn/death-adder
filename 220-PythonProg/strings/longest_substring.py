# A program to find the longest word in words.txt, that is a substring of
# some OTHER word in words.txt.  Also, some statistics are gathered:
#   1) time it takes to run (sans reading in the file)
#   2) number of find() calls were made (constitutes most work done in program)
#   3) percentage of word pairs, of which we actually performed a find()
#
# The last statistic, (3), tells us how effective the following statement is:
#      if len(word) > len(longest_word_substring):
#
# We know how many comparisons it would have required without this if statement:
#    max_compares = len(wordlist)*(len(wordlist)-1)/2          why?
#
# The count of the actual number of find calls is, substring_count.  So,
#     substring_count / max_compares
#
# gives us the fraction of maximum number of comparisons we actually
# performed.
from time import time

def main():
    infile = open("words.txt", "r")
    wordlist = infile.readlines()
    longest_word_substring = ""
    max_compares = len(wordlist)*(len(wordlist)-1)//2  # integer division
    print("maximum number of comparisons is " + str(max_compares))

    start_time = time()  # get the beginning time in seconds
    substring_count = 0  # count the number of substring comparisons
    
    while wordlist:  # as long as wordlist is not empty do the following:
        word = wordlist.pop()   # remove the LAST word on the list
        if len(word) > len(longest_word_substring):  # consider longer words
            for nextword in wordlist:  # for each remaining word in the list
                substring_count += 1
                if nextword.find(word) != -1:  # -1 means didn't find substring
                    longest_word_substring = word
                    print(word.rstrip(), "is a substring of", nextword.rstrip())

    end_time = time()  # get the ending time in seconds
    
    print("longest word substring is " + longest_word_substring)
    print("running time is " + str(end_time - start_time))
    print("number of substring comparisons is " + str(substring_count))
    print("percentage of max num comparisons is "
          + str(100*substring_count / max_compares)) # times 100 for percent

main()
