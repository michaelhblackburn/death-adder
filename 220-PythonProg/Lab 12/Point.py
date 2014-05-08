# Point.py - implements a mathematical point
# Author: Michael Blackburn

class Point():
    def __init__(self):
        self.x = 0
        self.y = 0

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def setX(self, newX):
        self.x = newX

    def setY(self, newY):
        self.y = newY

    def __str__(self):
        return "(" + str(self.x) + ", " + str(self.y) + ")"


    
