## Michael Blackburn, CSCI 220
## perseids.py
## This program was written soley by the author. Assistance with .clone() function provided
## by Dr. Leclerc

## Problem statement: Design a greeting card that uses the graphics package to create a house
##                                  with a blue sky, light brown grass, a white house, an orange door, two
##                                  windows, and a black roof. Also include five stars that animate across
##                                  the screen, a pleasant greeting, and instructions on how to terminate
##                                  the program when done.

from graphics import *

def main():
    ## Create a indow with dimension of 1000x1000
    win = GraphWin("Greeting Card", 1000, 1000)
    ## Set the background of the window to medium blue
    win.setBackground("Medium Blue")
    ## create a rectangle that will act as the main house structure,
    ## filled with white and having a white outline
    house = Rectangle(Point(400, 400), Point(600, 700))
    house.setFill("white")
    house.setOutline("white")
    ## draws the rectangle in the window
    house.draw(win)
    ## creates a rectangle to act as the lower porch facade,
    ## filled with white with a white outline
    lowerPorch = Rectangle(Point(600, 550), Point(700, 700))
    lowerPorch.setFill("white")
    lowerPorch.setOutline("white")
    ##draws the lower porch
    lowerPorch.draw(win)
    ## creates a line to delineate the bottom of the house from the grass, drawn later
    houseBottom = Line(Point(400, 700), Point(700, 700))
    houseBottom.setWidth(3)
    ## draws the line
    houseBottom.draw(win)
    ## creates a line that will act as a column between the lower porch and the roof, drawn later
    upperColumn = Line(Point(698, 400), Point(698, 550))
    upperColumn.setOutline("white")
    upperColumn.setWidth(6)
    ## draws the line
    upperColumn.draw(win)
    ## the following rail/slats create and draw a series of lines that create a handrail on the
    ## second floor porch
    rail = Line(Point(600, 500), Point(700, 500))
    rail.setOutline("white")
    rail.setWidth(4)
    rail.draw(win)
    slat1 = Line(Point(625, 500), Point(625, 550))
    slat1.setOutline("white")
    slat1.setWidth(4)
    slat1.draw(win)
    slat2 = slat1.clone()
    slat2.move(25, 0)
    slat2.draw(win)
    slat3 = slat2.clone()
    slat3.move(25, 0)
    slat3.draw(win)
    ## creates a rectangle foor an orange door that appears over the lower porch facade
    ## with a bolder outline that helps delineate the door from the facade
    door = Rectangle(Point(620, 580), Point(680, 700))
    door.setFill("orange")
    door.setWidth(3)
    ## draws the door
    door.draw(win)
    ## creates a small circle on the door that acts as the doorknob, filled with black 
    knob = Circle(Point(674, 645), 3)
    knob.setFill("black")
    ## draws the doorknob
    knob.draw(win)
    ## creates a rectangle for a window, filled with a light color to represent glass and
    ## a slightly bolder border for better delineation
    window1 = Rectangle(Point(430, 430), Point(480, 520))
    window1.setFill("Ivory2")
    window1.setWidth(2)
    ## draws the window
    window1.draw(win)
    ## the next lines clone the original window and moving and drawing it to positions across 
    ## the face of the house, giving it a total of four windows facing the viewer
    window2 = window1.clone()
    window2.move(90, 0)
    window2.draw(win)
    window3 = window1.clone()
    window3.move(0, 150)
    window3.draw(win)
    window4 = window3.clone()
    window4.move(90, 0)
    window4.draw(win)
    ## these commands create a vertical and horizontal line that intersect and will be drawn
    ## over the windows to create the impression of four panes in each windows. The lines are
    ## cloned and moved over each window.
    vertPane1 = Line(Point(455, 430), Point(455, 520))
    vertPane1.draw(win)
    horPane1 = Line(Point(430, 475), Point(480, 475))
    horPane1.draw(win)
    vertPane2 = vertPane1.clone()
    vertPane2.move(90,0)
    vertPane2.draw(win)
    horPane2 = horPane1.clone()
    horPane2.move(90,0)
    horPane2.draw(win)
    vertPane3 = vertPane1.clone()
    vertPane3.move(0, 150)
    vertPane3.draw(win)
    horPane3 = horPane1.clone()
    horPane3.move(0, 150)
    horPane3.draw(win)
    vertPane4 = vertPane3.clone()
    vertPane4.move(90, 0)
    vertPane4.draw(win)
    horPane4 = horPane3.clone()
    horPane4.move(90, 0)
    horPane4.draw(win)
    ## creates a chimney on the roof of the house, colored in firebrick
    chimney = Rectangle(Point(410, 340), Point(430, 400))
    chimney.setFill("Firebrick")
    ## draws the chimney
    chimney.draw(win)
    ## creates a polygon for the roof of the house, fills it in black
    roof = Polygon(Point(400, 400), Point(450, 350), Point(650, 350), Point(700, 400))
    roof.setFill("black")
    ## draws the roof
    roof.draw(win)
    ## this creates a polygon shaped as the trunk of a tree, filled with brown. This is drawn first, 
    ## as the foliage will be drawn over it second
    trunk = Polygon(Point(100, 700), Point(150, 650), Point(160, 400), Point(190, 400),
                    Point(200, 650), Point(250, 700))
    trunk.setFill("Saddle Brown")
    ## draws the trunk
    trunk.draw(win)
    ## this creates a circle for the treetop foilage, filled with green with a green outline
    treetop = Circle(Point(175, 400), 150)
    treetop.setFill("Dark Green")
    treetop.setOutline("Dark Green")
    ## draws the treetop
    treetop.draw(win)
    ## the next several commands create a single circle for a bush, filled with green with a green
    ## outline. The bushed is then cloned and moved several times to create the appearance
    ## of a hedge on both sides of the house
    bush1 = Circle(Point(345, 660), 50)
    bush1.setFill("Dark Green")
    bush1.setOutline("Dark Green")
    bush1.draw(win)
    bush2 = bush1.clone()
    bush2.move(-50, 0)
    bush2.draw(win)
    bush3 = bush1.clone()
    bush3.move(410, 0)
    bush3.draw(win)
    bush4 = bush3.clone()
    bush4.move(50, 0)
    bush4.draw(win)
    bush5 = bush4.clone()
    bush5.move(50, 0)
    bush5.draw(win)
    bush6 = bush5.clone()
    bush6.move(50, 0)
    bush6.draw(win)
    bush7 = bush6.clone()
    bush7.move(50, 0)
    bush7.draw(win)
    ## this crates a rectangle to represent the grass in the foreground in a light brown color
    ## with a light borwn outline
    grass = Rectangle(Point(0, 700), Point(1000, 1000))
    grass.setFill("Burlywood")
    grass.setOutline("Burlywood")
    ## draws the grass
    grass.draw(win)
    ## this creates a textual greeting that appears in the foreground in Helvetica typeface,
    ## with a font size of 36 pt, and colored red, then prints the message
    greeting = Text(Point(500, 850), "Greetings from Charleston!")
    greeting.setFace("helvetica")
    greeting.setSize(36)
    greeting.setTextColor("Firebrick")
    greeting.draw(win)
    ## this creates a textual instruction for users to close the window when they are done viewing.
    ## this is printed in a similar font and color as the previous message, but in smaller type.
    instructions = Text(Point(500, 950), "Click window to close")
    instructions.setFace("helvetica")
    instructions.setTextColor("Firebrick")
    instructions.draw(win)
    ## this series creates a polygon in the shape of a star, filled with yellow color, and then clones
    ## the star four times, for a total of five stars
    star1 = Polygon(Point(100, 100), Point(110, 125), Point(140, 130), Point(112, 140),
                    Point(120, 170), Point(100, 150), Point(80, 170), Point(88, 140),
                    Point(60, 130), Point(90, 125))
    star1.setFill("yellow")
    star1.draw(win)
    star2 = star1.clone()
    star2.move(-60, -60)
    star2.draw(win)
    star3 = star1.clone()
    star3.move(-60, 60)
    star3.draw(win)
    star4 = star1.clone()
    star4.move(60, -60)
    star4.draw(win)
    star5 = star1.clone()
    star5.move(60, 60)
    star5.draw(win)
    ## this loop then moves all five stars across the screen from one edge to the other
    for i in range(64):        
        star4.move(12, 0)
        star5.move(12, 0)
        star1.move(12, 0)
        star2.move(12, 0)
        star3.move(12, 0)

    ## this command pauses the program to wait for user input, a mouse click, then closes the program
    win.getMouse()
    win.close()
    
main()
