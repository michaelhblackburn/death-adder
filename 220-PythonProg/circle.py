from graphics import *

def main():
    win = GraphWin("Test", 350, 200)
    shape = Circle(Point(175, 100), 50)
    shape.setFill("blue")
    shape.draw(win)
    win.getMouse()
    win.close()

main()
