# Circle.py
# Michael Blackburn

from Point import Point
import math

class Circle():
    def __init__(self, xpoint, ypoint, r):
        self.radius = r
        self.center = Point()   # create point at (0, 0)
        self.center.setX(xpoint)
        self.center.setX(ypoint)

    def getCenter(self):
        return self.center

    def getRadius(self):
        return self.radius

    def setCenter(self, newX, newY):
        self.center.setX(newX)
        self.center.setY(newY)       

    def setRadius(self, newRadius):
        self.radius = newRadius

    def area(self):
        area = math.pi * self.radius ** 2
        return area

    def __str__(self):
        return "center: " + str(self.center) +"\nradius: " +str(self.radius)+"\narea: "+ str(Circle.area(self))
