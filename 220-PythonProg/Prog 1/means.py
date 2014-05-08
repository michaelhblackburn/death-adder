## means.py
## Michael Blackburn, CSCI 220-01
## Purpose: calculate the root mean square and harmonic mean of a set of numbers
## Note: This program was created by the author without outside assistance from another
##            party. Research on the math functions demonstrated herein performed using Wikipedia.

## This program will calculate the root mean square and harmonic mean of a given set of numbers
## by receiving from the user the number of entires to be calculated, followed by the entries
## themselves. The program will then display the calculated results for the root mean square and
## harmonic mean of the given numbers.
## The number of entries to be calculated will be stored in a variable named num_entries. The user
## will then give the first entry, which will be stored in a temporary variable named entry. This value
## is then transferred to two temporary variables, square and reciprocal. These will be used to
## calculate the square and reciprocal of entry. These respective values will then be placed in
## accumulators, sq_sum and rec_sum, which will be used to calculate the appropriate values.
## sq_sum will be used to calculate rms (root mean square), while rec_sum will be used to calculate
## hm (harmonic mean). After receiving all entries, calculations will be performed with the data
## entered, and the results for rms and hm will be displayed.

## Problem Algorithm
## 1. Request and receive number of entries from user (num_entries), set accumulators to 0
## 2. Enter definite loop for num_entries and prompt user for first entry
## 3. Entry placed in temporary value (entry)
## 4. square = entry ** 2
## 5. reciprocal = 1 / entry
## 6. sq_sum = sq_sum + square
## 7. rec_sum = rec_sum + reciprocal
## 8. End loop
## 9. Repeat loop for all entries
## 10. Calculate rms = ((1 / num_entries) * (sq_sum)) ** .5
## 11. Calculate hm = (num_entries / rec_sum)
## 12. Display results for rms
## 13. Display results for hm

def main():
    ## Greeting and basic instructions
    print ("This program will calculate the root mean sqaure and harmonic mean of a set of")
    print ("numbers. Please enter the number of entries to be averaged and a set of numbers")
    print ("where none of the numbers in the set equal zero.")
    ## Request for user to enter the number of entries to calculate
    num_entries = eval(input("Please enter the number of entries to calculate: "))
    ## set accumulators to 0 outside of loop
    sq_sum = 0
    rec_sum = 0
    ## begin deifintie loop defined by num_entries
    for i in range (num_entries):
        ## define entry by input given by user
        entry = eval(input("Enter a number: "))
        ## square number and place squared number in accumulator
        square = entry ** 2
        sq_sum = sq_sum + square
        ## reciprocate number and place reciprocal in accumulator
        reciprocal = 1 / entry
        rec_sum = rec_sum + reciprocal
    ## calculate rms 
    rms = ((1 / num_entries) * (sq_sum)) ** .5
    ## calculate harmonic mean
    hm = (num_entries / rec_sum)
    ## output results to user, formatted to 3 decimals
    print ("The root mean square is: ", round(rms, 3))
    print ("The harmonic mean is: ", round(hm, 3))
    ## processes tested successful with number set supplied by instructor [10, 5, 2, 5] rms 6.205 
    ## hm 4.0, as well as set [1, 2, 4] = rms 2.65, hm 1.71. Testing when any part of the set = 0 
    ## causes immediate error against division against zero.
main()
