# cupConverter.py
# Michael Blackburn

from graphics import *

def main():
    win = GraphWin("Find the number of mL", 300, 200)
    boxDesc = Text(Point(100, 50), "Input number of cups: ")
    boxDesc.draw(win)
    inp = Entry(Point(200, 50), 5)
    inp.setText("0")
    inp.draw(win)

    output = Text(Point(150, 150), "")
    output.draw(win)

    button = Text(Point(150, 100), "Click")
    button.draw(win)
    border = Rectangle(Point(115, 80), Point(185, 120))
    border.draw(win)

    win.getMouse()

    cups = eval(inp.getText())

    mL = (cups * 8) * 29.57
    rmL = round(mL, 2)

    output.setText(str(cups) + " cups = " + str(rmL) + " mL's")
    button.setText("Quit")
    
    win.getMouse()
    win.close()

main()
