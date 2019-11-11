# 209-project-4
Project 4
CSCI 209 Fall 2019
By Griffin Noe and Elyssa McMaster

===Features===
--Selection of shapes--
We utilized existing shape files from a previous project into a package (shapes) and imported them into our new code. A command pattern was utilized to select shapes on the GUI.
--Dragged shape preview--
updateRectangle is used so that every time the user moves their mouse around while holding, they are able to see what the shape will look like if they stop holding.
--Other features--
Right-click to remove the most recently added shape is implemented, and there are six additive and subtractive color options.

===ShapeHolder===
ShapeHolder is a singleton array of shapes that, through the use of ShapeHolderIterator, allows iteration through the list of shapes.
--Variables--
Shape[] shapes: the array of shapes
int counter: keeps track of the number of shapes in the array
private static ShapeHolder inst: static variable that instantiates the ShapeHolder
--Methods--
private ShapeHolder() sets the array to size 50
ShapeHolder getInstance() tests if inst is null; if it is null,
inst = new ShapeHolder(), and regardless, inst is returned
ShapeHolderIterator iterator() returns the iterator with the current shapeholder passed as the parameter
addShape adds a shape to the array
removeShape removes a shape from the array, as long as there is a shape to remove
ShapeHolderIterator(ShapeHolder sh) sets this.sh = sh
hasNext() returns a boolean: whether or not the shape has a next shape
next() throws a NoSuchElement exception if the shape does not have a next, or adds to the number of shapes in the array.

===ShapeDrawGUI===
This file creates the canvas, buttons, and action listeners for each button.
--Variables--
Canvas variable: sets the canvas for shapes to be drawn on
JButton and JCheckBox variables: create an interface with information to display to the user
GridBagLayout: a variable for the grid constant used for relative positioning
--Methods--
ActionListeners collect feedback from the user to update the interface
===Canvas===
This file works on the back end of ShapeDrawGUI and collects information from ShapeDrawGUI to draw shapes. This file utilizes a command pattern to set colors, fill, and shape.
--Variables--
posStart and posEnd describe the position of the rectangle drawn.   
java.awt.Rectangle drawRect is the rectangle drawn by the user with a shape inside.
String shapeType is a command variable that represents the shape selected by the user.
boolean fillType is a command variable that represents whether or not the "filled" check box has been clicked.
Color c is a command variable that represents the color selected by the user.
ShapeHolder sh is set to ShapeHolder.getInstance()
Shape ss is a command variable that casted into an instance of one of the individual shapes, and is used to be drawn, and is set back to null after something is drawn.
--Methods--
Canvas sets up the interface for the user.
setShapeType sets the String of the shape type to the shape selected by the user.
setColorType sets the String of the color selected by the user on the interface.
setFillType is a setter for whether or not the user selected the "filled" box.
paintComponent draws any shape from the holder within it.
drawGenericShape designates the type of shape selected to draw and allows for its setup.
The main method takes the information given by the user to make a display on the canvas.

