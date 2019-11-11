package shapes;
/**
 * @author Griffin Noe
 * Shape.java
 * This code creates an abstract class to allow
 * inheiritance from shape classes
 */



public abstract class Shape{
    protected boolean filled;
    protected String color; 
    protected String shapeType;
    protected int xCoordinate;
    protected int yCoordinate;


    /**
     * Shape constructor
     * @param xCoordinate x coordinate of a point on the shape
     * @param yCoordinate y coordinate of a point on the shape
     * @param color determines shape color
     * @param filled determines whether the shape is filled with color or only outlined
     */
    public Shape(int xCoordinate, int yCoordinate, String color, boolean filled){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
        this.filled = filled;
    }
    /**
     * toString method
     * @return string with information about shape
     */
    public String toString(){
        String str = "==" + getShapeType() + "==";
        return str;
    }
    /**
     * getFilled method
     * @return true or false if the shape is filled
     */

    public boolean getFilled(){
        return filled;
    }

    /**
     * getColor method
     * @return color of shape
     */
    public String getColor(){
        return color;
    }

    /**
     * getShapeType method
     * @return shape type
     */
    public String getShapeType(){
        return shapeType;
    }
    /**
     * getXCoordinate method
     * @return x coordinate of shape position
     */
    public int getXCoordinate(){
        return xCoordinate;
    }

    /**
     * getYCoordinate method
     * @return y coordinate of shape position
     */

    public int getYCoordinate(){
        return yCoordinate;
    }

    abstract public void update(int width, int height, int xCoordinate, int yCoordinate);
}