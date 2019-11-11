package shapes;
/**
 * @author Griffin Noe
 * Oval.java
 * This file creates a string with attributes of given oval
 */
public class Oval extends Circle{
    protected int radius2;

    /**
     * 
     * @param radius:
     * @param radius2
     * @param xCoordinate x-coordinate of the center of the oval
     * @param yCoordinate y-coordinate of the center of the oval
     * @param color designates a color for the shape
     * @param filled booelan describing whether the shape's color fills the shape or provides an outline
     */
    public Oval(int radius, int radius2, int xCoordinate, int yCoordinate, String color, boolean filled){
        super(radius, xCoordinate, yCoordinate, color, filled);
        this.radius2 = radius2;
        shapeType = "Oval";
    }

  /**
  * radius2 getter
  * @return radius2
  */
    public int getRadius2(){
        return radius2;
    }

/**
 * radius2 setter
 * @param radius2
 */
    public void setRadius2(int radius2){
        this.radius2 = radius2;
    }

    public void update(int radius, int radius2, int xCoordinate, int yCoordinate){
        this.radius = radius;
        this.radius2 = radius2;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    
/**
 * toString method
 * @return string with information about the shape
 */
    public String toString(){
        String str = "==" + getShapeType() + "==";
        str += "\nRadius 1: " + radius;
        str += "\nRadius 2: " + radius2;
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n====\n";
        return str;
    }
}