## circle.py
## Michael Blackburn

import math
from graphics import *

def main():
    win = GraphWin("Circle", 400, 400)
    width = win.getWidth()
    height = win.getHeight()

    instPt = Point(width/2, height-10)
    instructions = Text(instPt,"Click the center of the circle")
    instructions.draw(win)
    c = win.getMouse()
    instructions.setText("Click the outer edge of the circle")
    p = win.getMouse()

    a = c.getX()
    b = c.getY()
    s = p.getX()
    t = p.getY()

    r = math.sqrt(((a-s)**2)+((b-t)**2))

    shape = Circle(Point(a, b), r)
    shape.setOutline("green")
    shape.setFill("green")
    shape.draw(win)
    
    instructions.setText("Click again to close")
    win.getMouse()
    win.close()

main()
