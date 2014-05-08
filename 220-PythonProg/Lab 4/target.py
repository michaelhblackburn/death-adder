## Michael Blackburn
## target.py
from graphics import *

def main():
    r = eval(input("Enter the radius of the center circle: "))
    width = 300
    height = 300
    win = GraphWin("Target", width, height)
    center = Point(width // 2, height // 2)
    w = Circle(center, r*5)
    w.setFill("white")
    w.draw(win)
    bk = Circle(center, r*4)
    bk.setFill("black")
    bk.draw(win)
    bl = Circle(center, r*3)
    bl.setFill("blue")
    bl.draw(win)
    rd = Circle(center, r*2)
    rd.setFill("red")
    rd.draw(win)
    y = Circle(center, r)
    y.setFill("yellow")
    y.draw(win)
    maxTargetRad = (width / 2) / 5
    minTargetRad = width / width
    maximum = Text(Point(150, 250), "The maximum target size is "+ str(maxTargetRad))
    maximum.setTextColor("red")
    maximum.draw(win)
    minimum = Text(Point(150, 275), "The minimum target size is "+ str(minTargetRad))
    minimum.setTextColor("red")
    minimum.draw(win)
    win.getMouse()
    win.close()

main()
