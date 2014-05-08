## circleOverlap.py
## Michael Blackburn

from graphics import *
from math import sqrt

def main():
    #Build window
    winHeight = 400
    winWidth = 400
    win = GraphWin("Overlapping circles", winHeight, winWidth)

    #Text area for instructions for user
    instruct = Text(Point(winWidth/2, winHeight-10), "")
    instruct.draw(win)

    #Get center point and x/y for center
    instruct.setText("To draw a circle, click the centerpoint for the circle")
    center = win.getMouse()
    center.draw(win)
    cX = center.getX()
    cY = center.getY()

    #Get point on the circumference and its x/y coordinates
    instruct.setText("Click a point on the border of the circle.")
    border = win.getMouse()
    bX = border.getX()
    bY = border.getY()

    #Calculate radius using Euclidean distance
    radius = sqrt((cX-bX) ** 2 + (cY-bY) ** 2)
    circle = Circle(center, radius)
    circle.draw(win)

    #Draw the second circle
    instruct.setText("To draw another circle, click the centerpoint for the circle")
    center2 = win.getMouse()
    center2.draw(win)
    c2X = center2.getX()
    c2Y = center2.getY()
    instruct.setText("Click a point on the border of the second circle.")
    border2 = win.getMouse()
    b2X = border2.getX()
    b2Y = border2.getY()
    radius2 = sqrt((c2X-b2X) ** 2 + (c2Y-b2Y) ** 2)
    circle2 = Circle(center2, radius2)
    circle2.draw(win)

    #Calculate the distance between the two radii
    distance = sqrt((abs(c2X-cX) **2 + abs(c2Y-cY) ** 2))
    radiusSum = radius + radius2
    
    #Check overlap
    if radiusSum >= distance:
        instruct.setText("The circles overlap. Click to continue")
    else:
        instruct.setText("The circles do not overlap. Click to continue.")
    win.getMouse()
    # Wait for another click to exit
    instruct.setText("Click anywhere to close.")
    win.getMouse()
    win.close()

main()
