package shapes;
/**
 * @author Elyssa McMaster
 * Triagnle.java
 * This file creates a string with attributes of a given triangle
 */

public class Triangle extends Shape{
    private int[] xCoords;
    private int[] yCoords;
    private int width;
    private int height;
    private double side;



    // methods to find initial x coord, y coord, fill, 
    // and color have already been included in the class
    // this one inheirits from

    /**
     * 
     *  Triangle Constructor 
     * 
     * @param width: width of square within which the octagon is drawn
     * @param height: height of square within which the octagon is drawn
     * @param xCoordinate: starting x-position of the drawing of the octagon
     * @param yCoordinate: starting y-position of the drawing of the octagon
     * @param color: color of the shape
     * @param filled: whether the shape is filled in or the color is just for the outline
     */

    public Triangle(int width, int height, int xCoordinate, int yCoordinate, java.awt.Color color, boolean filled){
        super(xCoordinate, yCoordinate, color, filled);
        this.width = width;
        this.height = height;

        xCoords = new int[3];
        xCoords[0]= xCoordinate + width/2;
        xCoords[1]=xCoordinate + width;
        xCoords[2]=xCoordinate;
    
        yCoords = new int[3];
        yCoords[0]= yCoordinate;
        yCoords[1]=yCoordinate + height;
        yCoords[2]=yCoordinate + height;
    
        shapeType = "Triangle";
    }

     /**
     * 
     * Width getter
     * @return width
     */

    public double getWidth(){
        return width;
    }

     /**
     * 
     * Height getter
     * @return height
     */

    public double getHeight(){
        return height;
    }

    public int[] getXCoords(){
        return xCoords;
    }

    public int[] getYCoords(){
        return yCoords;
    }

    public void update(int width, int height, int xCoordinate, int yCoordinate){
        this.width = width;
        this.height = height;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * toString prints attributes of triangle
     * @return string of attributes in proper format
     */

    public String toString(){
        String str = super.toString();
        double width1 = width;
        str += "\nWidth: " + width;
        str += "\nHeight: " + height;
        str += "\nCoordinates: " + "(" +xCoords[0] + "," + yCoords[0] +")";
        str += ", (" + xCoords[1] + "," +yCoords[1] +")";
        str += ", (" + xCoords[2] + "," +yCoords[2] +")";
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n";
        side = Math.sqrt(Math.pow(height, 2)+Math.pow(width, 2)/4);
        str += "\nSide 1: " + side;
        str += "\nSide 2: " + width1;
        str += "\nSide 3: " + side;
        str += "\nPerimeter: " + (side *2 + width);
        str += "\n====";
        return str;
     
    }
}