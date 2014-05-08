# hiLoGame.py
# Michael Blackburn

from random import randint

def main():
    num = randint(1, 100)
    print(num)
    guess = 0
    win = False    
    while guess < 7 and win == False:
        entry = eval(input("Guess the number: "))
        if entry != num:
            if entry > num:
                print("Too high.")
            elif entry < num:
                print("Too low.")
        else:
            print("Correct!")
            win = True
        guess += 1
        
    if win == True:
        print("You win in", guess, "guesses.")
    else:
        print("Sorry, you lose. The number was", num)
