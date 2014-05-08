## Michael Blackburn
## triangle.py

import math
from graphics import *

def main():
    win = GraphWin("Triangle", 400, 400)
    p1 = win.getMouse()
    p2 = win.getMouse()
    p3 = win.getMouse()
    triangle = Polygon(p1, p2, p3)
    triangle.draw(win)
    r = p1.getX()
    s = p1.getY()
    t = p2.getX()
    u = p2.getY()
    v = p3.getX()
    w = p3.getY()
    l1dx = abs(r - t)
    l1dy = abs(s - u)
    l2dx = abs(t - v)
    l2dy = abs(u - w)
    l3dx = abs(r - v)
    l3dy = abs(s - w)
    l1 = math.sqrt((l1dx)**2 + (l1dy)**2)
    l2 = math.sqrt((l2dx)**2 + (l2dy)**2)
    l3 = math.sqrt((l3dx)**2 + (l3dy)**2)
    perimeter = l1 + l2 + l3
    ss = (l1 + l2 + l3) / 2
    area = math.sqrt(ss * (ss - l1) * (ss - l2) * (ss - l3))
    perMessage = Text(Point(200, 350), "The perimeter is: "+str(perimeter))
    perMessage.draw(win)
    areaMessage = Text(Point(200, 375), "The area is: "+str(area))
    areaMessage.draw(win)
    win.getMouse()
    win.close()

main()
