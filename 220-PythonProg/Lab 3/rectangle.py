## rectangle.py
## Michael Blackburn

from graphics import *

def main():
    win = GraphWin("Rectangle", 400, 400)
    width = win.getWidth()
    height = win.getHeight()

    instPt = Point(width/2, height-10)
    instructions = Text(instPt,"Click the first point")
    instructions.draw(win)
    c1 = win.getMouse()

    instructions.setText("Click the second point")
    c2 = win.getMouse()

    p1 = c1.getX()
    p2 = c1.getY()
    p3 = c2.getX()
    p4 = c2.getY()

    shape = Rectangle(Point(p1, p2), Point( p3, p4))
    shape.setOutline("blue")
    shape.setFill("blue")
    shape.draw(win)

    length = abs(p4 - p2)
    width = abs(p3 - p1)
    area = (length * width)
    perimeter = (2 * (length + width))

    instructions.setText("Area  = "+str(area) +" Perimeter = "+ str(perimeter))
    win.getMouse()
    win.close()
main()
