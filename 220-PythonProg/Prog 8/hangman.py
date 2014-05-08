## hangman.py
## Michael Blackburn, CSCI 220
## Assistance with numerous aspects provided by Dr. Leclerc

import random
from graphics import *

def readFile():
    infile = open("wordlist.txt", "r")
    wordList = infile.readlines()
    infile.close()
    return wordList

def randomWord(wordList):
    randNum = random.randint(0, len(wordList)-1)
    randWord = wordList[randNum]
    return randWord.rstrip()

def maskWord(secretWord):
    mask = ""
    for i in range(len(secretWord)):
        mask = mask + "_"
    return mask

def printMask(mask):
    for i in mask:
        print(i, end = " ")
    print()

def createNewMask(mask):
    s = ""
    for i in mask:
        s = s + i + " "
    return s

def correctWord(mask):
    numUnderscores = mask.count("_")
    if numUnderscores > 0:
        return False
    else:
        return True
    
def playGame():
    play = True
    while play == True:
        win = GraphWin("Hangman", 600, 600)
        base = Line(Point(150, 400), Point(550, 400))
        pole = Line(Point(520, 25), Point(520, 400))
        gallow = Line(Point(350, 25), Point(520, 25))
        rope = Line(Point(350, 25), Point(350, 50))
        head = Circle(Point(350, 90), 40)
        torso = Line(Point(350, 130), Point(350, 230))
        rightArm = Line(Point(280, 150), Point(350, 150))
        leftArm = Line(Point(350, 150), Point(420, 150))
        rightLeg = Line(Point(350, 230), Point(300, 350))
        leftLeg = Line(Point(350, 230), Point(400, 350))
        mouth = Circle(Point(350, 120), 5)
        mouth.setFill("black")
        body = [mouth, leftLeg, rightLeg, leftArm, rightArm, torso, head]
        message = Text(Point(299, 420), "Welcome to Hangman!")
        message.setSize(24)
        entryMessage = Text(Point(250, 450), "Enter a letter: ")
        entryMessage.setSize(20)
        entryBox = Entry(Point(320, 450), 1)
        entryButton = Rectangle(Point(350, 435), Point(420, 465))
        buttonLabel = Text(Point(385, 450), "ENTER")
        entryButton.draw(win)
        buttonLabel.draw(win)
        entryBox.draw(win)
        base.draw(win)
        pole.draw(win)
        gallow.draw(win)
        rope.draw(win)
        message.draw(win)
        entryMessage.draw(win)
        wordList = readFile()
        secretWord = randomWord(wordList)
        mask = maskWord(secretWord)
        maskImage = Text(Point(299, 550), createNewMask(mask))
        maskImage.setSize(36)
        maskImage.draw(win)
        guessesLeft = 7
        guessedLetters = []
        usedList = Text(Point(299, 510), "Letters already guessed: "+str(guessedLetters))
        usedList.draw(win)
        while guessesLeft > 0 and mask != secretWord:
            entryBox.setText("")
            alreadyUsed = Text(Point(299, 480), "")
            alreadyUsed.draw(win)
            click = win.getMouse()
            if click.getX() >= 350 and click.getX() <= 420:
                if click.getY() >= 435 and click.getY() <= 465:
                   guess = entryBox.getText()
                   found = False
                   for i in range(len(guessedLetters)):
                       if guess == guessedLetters[i]:
                           alreadyUsed.setText("That letter has already been guessed. Guess again.")
                           found = True
                           
                   if not found:
                           guessedLetters.append(guess)
                           
                   found = False
                   for i in range(len(secretWord)):
                          if guess.lower() == secretWord[i]:
                               found = True
                               mask = mask[0:i] + secretWord[i] + mask[i+1:]
                   usedList.setText("Letters already guessed: "+str(guessedLetters))
                   
                   if found == False:
                       for i in range(len(guessedLetters)):
                           if guess == guessedLetters[i]:
                               found = True
                           else:
                              guessesLeft -= 1
                              body[guessesLeft].draw(win)

                   maskImage.undraw()
                   maskImage.setText(createNewMask(mask))
                   maskImage.draw(win)
        correct = correctWord(mask)
        if correct == True:
            victoryMessage = Text(Point(299, 580), "Congratulations - you win!")
            victoryMessage.draw(win)
        else:
            defeatMessage = Text(Point(299, 580), "You lose. The secret word was "+str(secretWord)+".")
            defeatMessage.draw(win)
        yesButton = entryButton.clone()
        yesButton.move(-300, -400)
        yesLabel = Text(Point(85, 50), "YES")
        noButton = entryButton.clone()
        noButton.move(-200, -400)
        noLabel = Text(Point(185, 50), "NO")
        playMessage = Text(Point(130, 15), "Play again?")
        yesButton.draw(win)
        noButton.draw(win)
        yesLabel.draw(win)
        noLabel.draw(win)
        playMessage.draw(win)
        win.getMouse()
        if click.getX() >= 50 and click.getX() <= 120:
                if click.getY() >= 35 and click.getY() <= 65:
                    play = True
        elif click.getX() >= 150 and click.getX() <= 220:
                if click.getY() >= 35 and click.getY() <= 65:
                    play = False
                    
    win.close()
                
def main():
    playGame()

main()
    
