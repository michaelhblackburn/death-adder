## Discussion #3
## Michael Blackburn

from graphics import *

def main():
    #Creates a graphical window
    win = GraphWin("Lab 3", 400, 400)
    width = win.getWidth()
    height = win.getHeight()

    #number of times user can move circle
    numClicks = 5

    #create a space to instruct user
    instPt = Point(width/2, height-10)
    instructions = Text(instPt,"Click to draw a new square")
    instructions.draw(win)

    #builds a square
    shape = Rectangle(Point(50, 50), Point( 80, 80))
    shape.setOutline("red")
    shape.setFill("red")
    shape.draw(win)

    #allows the user to click multiple times to draw a new square
    for i in range(numClicks):
        p = win.getMouse()
        x = p.getX()
        y = p.getY()
        shape = Rectangle(Point(x, y), Point(x+30, y+ 30))
        shape.setOutline("red")
        shape.setFill("red")
        shape.draw(win)
        

    instructions.setText("Click again to quit")
    win.getMouse()
    win.close()

main()
