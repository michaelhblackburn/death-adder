# jumpingJack.py - SOLUTION
# Author: RoxAnn H Stalvey
# Slightly revised by Pharr
# Modified as a template by Leclerc
# Completed by Michael Blackburn, CSCI 220
#
# Draw stick figure and program buttons to have him do jumping
# jacks and stop jumping.  Third button to end program.

from graphics import *
import time

def wasClicked (pt, rect):
    # put your code here for wasClicked
    if pt != None:
        p1 = rect.getP1()
        p2 = rect.getP2()
        if pt.getX() >= p1.getX() and pt.getX() <= p2.getX():
            if pt.getY() >= p1.getY() and pt.getY() <= p2.getY():
                return True
        else:
            return False
        
def main():
    win = GraphWin("Jumping Jack",600,500)
    win.setBackground("yellow")
    
    #stickman's head
    headRadius = 20
    head = Circle(Point(300,100),headRadius)
    head.setFill("white")
    head.draw(win)

    #body
    body = Line(Point(300,120), Point(300,200))    
    body.draw(win)

    #legs
    ltLegOpen = Line(Point(300,200), Point(330,230))
    rtLegOpen = Line(Point(300,200), Point(270,230))
    ltLegShut = Line(Point(300,200), Point(305,245))
    rtLegShut = Line(Point(300,200), Point(295,245))
    rtLegShut.draw(win)
    ltLegShut.draw(win)  

    #arms
    ltArmUp = Line(Point(300,150), Point(270, 110))
    rtArmUp = Line(Point(300,150), Point(330, 110))
    ltArmDown = Line(Point(300,150), Point(335,180))
    rtArmDown = Line(Point(300,150), Point(265,180))
    rtArmDown.draw(win)
    ltArmDown.draw(win)

    buttonBox = Rectangle(Point(0,415), Point(600,500))
    buttonBox.setFill("white")
    buttonBox.draw(win)            

    #start button
    start = Rectangle(Point(115, 430), Point(185, 470))
    startText = Text(Point(150, 450), "Start")
    start.draw(win)
    startText.draw(win)

    #stop button
    stop = Rectangle(Point(255, 430), Point(325, 470))
    stopText = Text(Point(295, 450), "Stop")
    stop.draw(win)
    stopText.draw(win)
    
    #quit button
    quitButton = Rectangle(Point(395, 430), Point(465, 470))
    quitText = Text(Point(430, 450), "Quit")
    quitButton.draw(win)
    quitText.draw(win)

    #instructions for user
    Text(Point(300,300), "Click Start to make Jack jump").draw(win)
    Text(Point(300,325), "Click Stop to make Jack stop").draw(win)
    Text(Point(300,350), "Click Quit to end the program").draw(win)

    #wait for click before clearing instructions
    click = win.getMouse()

    quitClicked = False
    stopClicked = True

    while quitClicked is False:
        if stopClicked is not True:
        
    
    win.close()

main()
