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
setLayout sets the layout for the GUI
setSize sets the size for the canvas
