## cdTime.py
## Michael Blackburn, CSCI 220-01
## This program was written solely by the author, with no outside assistance given.

## The goal of this program, as outlined by the assignment documentation, was two-fold: part
## one allowed the user to enter the number of tracks on a disc, and then allowed the user to 
## enter the number of minutes and seconds for each track on the disc, and calculated the total
## time of the disc. This step required the user to re-run the program for each disc, which
## prompted the revision performed for part two, the final form of the program. The user enters
## the number of discs which they want to catalogue, then enters the number of tracks on the
## first disc. The user will then enter the number of minutes and seconds on each track. When
## times for all tracks are entered, the program outputs the total time of the disc in minutes and
## seconds. The program then asks for the number of tracks on the next disc, followed by the
## minutes and seconds for each track, and the the output of total time for the disc. This process
## repeats for each disc entered at the beginning. When times for all tracks on all discs have been
## entered, the program will output the total time for all tracks on all discs in hours, minutes, and
## seconds.

## Problelm Algorithm for final specifications
## 1. set a counter for the total time to 0
## 2. enter the number of discs to calculate
## 3. enter outer loop for discs, set counter for time of each disc to 0
## 4. enter the number of tracks on the disc
## 5. enter the inner loop for tracks on the disc
## 6. enter the number of minutes and seconds for each track
## 7. calculate the total time for each track in seconds, add  track time to counter for disc time
## 8. when process for each disc is complete,  exit loop and add disc time to counter for total time
## 9. calculate and output disc time in munites and seconds
## 10. loop begins for next disc, repeat steps 4 through 9 for each disc
## 11. after final disc is complete, calculate and output the total time for all discs

def main():
    ## set counter for the total time to 0
    total_time = 0
    ## enter the number of discs to evaluate
    discs = eval(input("Enter the number of discs to calculate: "))
    ## begin outer loop for discs
    for d in range(1, discs +1):
        ## set counter for disc time to 0
        time = 0
        ## enter the number of tracks on the disc to evaluate
        print("Enter the number of tracks on disc",d)
        tracks = eval( input())
        ## begin inner loop for tracks
        for i in range(1, tracks + 1):
            ## enter minutes and seconds for each track
            print("Enter the number of minutes in track",i)
            minutes = eval( input())
            print("Enter the number of seconds in track",i)
            seconds = eval( input())
            ## add the time for each disc (in seconds) to the counter
            time = time + (seconds + (minutes * 60))

        ## add the time for each disc to the counter for total time (in seconds)        
        total_time = total_time + time
        ## calculate and output the total time for each disc
        disc_minutes = time // 60
        disc_seconds = time % 60
        print("CD",d,"total time: ",disc_minutes,"minutes",disc_seconds,"seconds")
    ## calculate the total time for all discs and output the total
    total_seconds = total_time % 60
    final_minutes = total_time // 60
    total_minutes = final_minutes % 60
    total_hours = final_minutes // 60
    print("Total time for all CD's:",total_hours,"hours",total_minutes,"minutes",total_seconds,"seconds")
    
main()
## Program tested against two value sets: a simple set, with one track of 30 minutes, 30 seconds
## on each of three discs (total 1:31:30), and a second set of more complicated values,
## noted as follows:
## Disc 1   4:32, 3:13, 3:28, 4:01, 3:54 (total for disc 19:08)
## Disc 2   5:15, 3:44, 4:04, 5:12, 3:55 (total for disc 22:10)
## total for both discs: 41:18
