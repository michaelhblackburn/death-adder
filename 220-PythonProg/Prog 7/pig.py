## pig.py
## Michael Blackburn, CSCI 220
## This program was written solely by the author. Class discussion involved the first two functions
## written, roll() and playerPlays(totalPlayerPoints). No other outside assistance was used.

## This program is designed as an interactive game to simulate to players, the user and a computer
## player, competing in a dice game. Using a function to simulate random numbers, the players
## "roll dice" and accumulate points. Should either player roll a 1, that player receives no points
## for their turn, and control passes to the next player. Should either player roll two 1's (snake eyes),
## that player forfeits all accumulated points for the game, and cedes control to the other player.
## The user may elect to pass control on any roll after the first in a turn. The computer will
## automatically pass control after accumulating 20 or more points in a turn. Once either player
## reaches 100, the game ends, and the program asks if the user wants to play again. If they
## answer yes, a new game begins; no, and the program ends.

import random

# This function produces pseudo-random numbers representing the dice rolls.
def roll():
        number = random.randint(1, 6)
        return number

# This function controls game play during the player's turn. 
def playerPlays(totalPlayerPoints):
    turnPoints = 0
    dice1, dice2 = roll(), roll()
    play = True
    while play == True:
        print("Die 1 =", dice1)
        print("Die 2 =", dice2)
        if dice1 == 1 or dice2 == 1:
            if dice1 ==1 and dice2 == 1:
                turnPoints = 0
                totalPlayerPoints = 0
                print("Turn points = 0")
                play = False
            else:
                turnPoints = 0
                print("Turn points = 0")
                play = False
        else:
            turnPoints += dice1 + dice2
            print("Turn points =", turnPoints)
            if turnPoints < 100:
                    cont = input("Continue playing? (enter Y or N): ")
                    if cont.upper() == "Y":
                        play = True
                        dice1, dice2 = roll(), roll()
                    else:
                        play = False
            else:
                   play = False
                
    totalPlayerPoints += turnPoints
    return totalPlayerPoints

# This function controls game play during the computer's turn.
def computerPlays(totalComputerPoints):
    turnPoints = 0
    dice1, dice2 = roll(), roll()
    play = True
    while play == True:
        print("Die 1 =", dice1)
        print("Die 2 =", dice2)
        if dice1 == 1 or dice2 == 1:
            if dice1 == 1 and dice2 == 1:
                turnPoints = 0
                totalComputerPoints = 0
                print("Turn points = 0")
                play = False
                return totalComputerPoints
            else:
                turnPoints = 0
                print("Turn points = 0")
                play = False
        else:
             turnPoints += dice1 + dice2
             print("Turn points =", turnPoints)
             if turnPoints < 20:
                play = True
                dice1, dice2 = roll(), roll()
             else:
                 play = False
                 
    totalComputerPoints += turnPoints
    return totalComputerPoints

# This function controls the overall game, ending when either player reaches 100 points, and
# outputting the final scores.
def playPig():
    print("Welcome to Pig!")
    playerPoints = 0
    computerPoints = 0
    while playerPoints < 100 and computerPoints < 100:
        print()
        print("Player plays!")
        print()
        playerPoints = playerPlays(playerPoints)
        if playerPoints < 100:
                print()
                print("Computer plays!")
                print()
                computerPoints = computerPlays(computerPoints)

    print()
    print("Total player points =", playerPoints)
    print("Total computer points =", computerPoints)
    print()
    if playerPoints > computerPoints:
        print("Player wins!")
    else:
        print("Computer wins!")

def main():
    playPig()
    play = True
    while play == True:
        print()
        anotherGame = input("Would you like to play again? (enter Y or N): ")
        if anotherGame.upper() == "Y":
            play = True
            playPig()
        else:
            play = False
            
    
main()
