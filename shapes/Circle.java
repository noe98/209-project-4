package shapes;
/**
 * @author Griffin Noe
 * Oval.java
 * This file creates a string with attributes of given oval
 */
public class Circle extends Shape{
    protected int radius;
/**
 * 
 * @param radius radious of the circle
 * @param xCoordinate x-coordinate of the center of the circle
 * @param yCoordinate y-coordinate of the center of the circle
 * @param color designates a color for the shape
 * @param filled booelan describing whether the shape's color fills the shape or provides an outline
 */
    public Circle(int radius, int xCoordinate, int yCoordinate, String color, boolean filled){
        super(xCoordinate,yCoordinate,color,filled);
        this.radius = radius;
        shapeType = "Circle";
    }

/**
 * radius getter
 * @return radius
 */
    public int getRadius(){
        return radius;
    }

/**
 * radius setter
 * @param radius
 */
    public void setRadius(int radius){
        this.radius = radius;
    }

    public void update(int radius, int xCoordinate, int yCoordinate){
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

/**
 * toString method
 * @return string with information about the shape
 */
    public String toString(){
        String str = super.toString();
        str += "\nRadius: " + radius;
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n====\n";
        return str;
    }

}