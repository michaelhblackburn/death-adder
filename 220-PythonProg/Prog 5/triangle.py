# triangle.py
# Michael Blackburn, CSCI 220
# Modified from Zelle version found in book
# Formulas for distance, perimeter, and area found in book
# Assistance given as noted above; all other work is the sole work of the author

# This problem required modification of an existing program to include functions for calling
# in main. The new program required functions for: creating a triangle when passed a group
# of points, a function to calculate the distance between two points passed to the function,
# and functions to calculate the perimeter and area of a triangle when passed the triangle
# as an object. The perimeter and area must then be written to the window for viewing by the
# user. 

from graphics import *
import math
# function for creating a triangle when passed three points
def makeTriangle(p1, p2, p3):
    triangle = Polygon(p1, p2, p3)
    triangle.setFill("blue")
    triangle.setOutline("blue")
    return triangle
# function to calculate the distance between two points, when passed two points, and returns
# the distance
def distance(p1, p2):
    dist = math.sqrt((p2.getX() - p1.getX())**2 + (p2.getY() - p1.getY())**2)
    return dist
# calculates the perimeter of a triangle when passed the triangle as an object. The function first
# determines a list of points contained in the triangle, assigns those points to local variables
# for use in calculations, makes the calculations, and returns the perimeter.
def triPerim(triShape):
    points = triShape.getPoints()
    p1 = points[0]
    p2 = points[1]
    p3 = points[2]
    perim = distance(p1, p2) + distance(p2, p3) + distance(p3, p1)
    return perim
# calculates the area of a triangle when passed the triangle as an object. The function first
# determines a list of points contained in the triangle, assigns those points to local variables
# for use in the function, makes the calculations, and returns the area.	
def triArea(triShape):
    points = triShape.getPoints()
    p1 = points[0]
    p2 = points[1]
    p3 = points[2]
    s = (distance(p1, p2) + distance(p2, p3) + distance(p3, p1)) / 2
    a = math.sqrt(s * (s - distance(p1, p2)) * (s - distance(p2, p3)) * (s - distance(p3, p1)))
    return a

def main():
    # Define points and draw a window
    winWidth = 400
    winHeight = 400
    win = GraphWin("Draw a Triangle", winWidth, winHeight)
    # Write a message telling the user to click on three points to make a triangle
    message = Text(Point(winWidth/2, winHeight-10), "Click on three points")
    message.draw(win)

    # Get and draw three points of the triangle
    p1 = win.getMouse()
    p1.draw(win)
    p2 = win.getMouse()
    p2.draw(win)
    p3 = win.getMouse()
    p3.draw(win)
    # Call function to create a triangle and then draw that triangle in main
    triangle = makeTriangle(p1, p2, p3)
    triangle.draw(win)
    # Call functions to calculate the perimeter and area of the triangle
    perimeter = triPerim(triangle)
    area = triArea(triangle)
    # Write the perimeter and area to the window
    pText = Text(Point(200, 350), "The perimeter is "+str(round(perimeter, 2)))
    pText.draw(win)
    aText = Text(Point(200, 365), "The area is "+str(round(area, 2)))
    aText.draw(win)

    # Wait for another click to close the window
    message.setText("Click anywhere to quit")
    win.getMouse()
    win.close()

main()
