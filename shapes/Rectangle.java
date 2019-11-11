package shapes;
/**
 * @author Elyssa McMaster
 * Rectangle.java
 * This file creates a string with attributes of a given rectangle
 */

public class Rectangle extends Shape{
    private int[] xCoords;
    private int[] yCoords;
    private int width;
    private int height;



    // methods to find initial x coord, y coord, fill, 
    // and color have already been included in the class
    // this one inheirits from


    /**
     * 
     *  Rectangle Constructor 
     * 
     * @param width: width of square within which the octagon is drawn
     * @param height: height of square within which the octagon is drawn
     * @param xCoordinate: starting x-position of the drawing of the octagon
     * @param yCoordinate: starting y-position of the drawing of the octagon
     * @param color: color of the shape
     * @param filled: whether the shape is filled in or the color is just for the outline
     */

    public Rectangle(int width, int height, int xCoordinate, int yCoordinate, java.awt.Color color, boolean filled){
        super(xCoordinate, yCoordinate, color, filled);
        this.width = width;
        this.height = height;

        xCoords = new int[4];
        xCoords[0]= xCoordinate;
        xCoords[1]= xCoordinate + width;
        xCoords[2]= xCoordinate + width;
        xCoords[3] = xCoordinate;
    
        yCoords = new int[4];
        yCoords[0]= yCoordinate;
        yCoords[1]=yCoordinate;
        yCoords[2]=yCoordinate + width;
        yCoords[3] = yCoordinate + width;
            
        shapeType = "Rectangle";
    }


    /**
     * 
     * Width getter
     * @return width
     */

    public int getWidth(){
        return width;
    }
        
    /**
     * 
     * Height getter
     * @return height
     */

    public int getHeight(){
        return height;
    }

    public void update(int width, int height, int xCoordinate, int yCoordinate){
        this.width = width;
        this.height = height;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * toString prints attributes of Rectangle
     * @return string of attributes in proper format
     */

    public String toString(){
        String str = super.toString();
        double width1 = width;
        double height1 = height;
        str += "\nWidth: " + width;
        str += "\nHeight: " + height;
        str += "\nCoordinates: " + "(" +xCoords[0] + "," + yCoords[0] +")";
        str += ", (" + xCoords[1] + "," +yCoords[1] +")";
        str += ", (" + xCoords[2] + "," +yCoords[2] +")";
        str += ", (" + xCoords[3] + "," +yCoords[3] +")";
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n";
        str += "\nSide 1: " + width1;
        str += "\nSide 2: " + height1;
        str += "\nSide 3: " + width1;
        str += "\nSide 3: " + height1;
        str += "\nPerimeter: " + (2 * width1 + 2 * height1);
        str += "\n====";
        return str;
    }
    
}