from graphics import *
import time

win = GraphWin('Shapes')

center = Point(100, 100)
circle = Circle(center, 30)
circle.setFill('red')
circle.draw(win)

label = Text(center, "Red Circle")
label.draw(win)

rect = Rectangle(Point(30, 30), Point(70, 70))
rect.draw(win)

line = Line(Point(20, 30), Point(180, 165))
line.draw(win)

oval = Oval(Point(20, 150), Point(180, 199))
oval.draw(win)

print("center = (", center.getX(), ",", center.getY(), ")")

time.sleep(10)
win.close()

