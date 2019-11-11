package shapes;
/**
 * @author Elyssa McMaster
 * Square.java
 * This file creates a string with attributes of given square
 */

public class Square extends Shape{
    private int[] xCoords;
    private int[] yCoords;
    private int width;



    // methods to find initial x coord, y coord, fill, 
    // and color have already been included in the class
    // this one inheirits from

    /**
     * 
     *  Square Constructor 
     * 
     * @param width: width of square within which the octagon is drawn
     * @param xCoordinate: starting x-position of the drawing of the octagon
     * @param yCoordinate: starting y-position of the drawing of the octagon
     * @param color: color of the shape
     * @param filled: whether the shape is filled in or the color is just for the outline
     */

    public Square(int width, int xCoordinate, int yCoordinate, java.awt.Color color, boolean filled){
        super(xCoordinate, yCoordinate, color, filled);
        this.width = width;

        xCoords = new int[4];
        xCoords[0]= xCoordinate;
        xCoords[1]=xCoordinate + width;
        xCoords[2]=xCoordinate + width;
        xCoords[3] = xCoordinate;
    
        yCoords = new int[4];
        yCoords[0]= yCoordinate;
        yCoords[1]=yCoordinate;
        yCoords[2]=yCoordinate + width;
        yCoords[3] = yCoordinate + width;
        
        shapeType = "Square";
    }

    /**
     * 
     * Width getter
     * @return width
     */

    public int getWidth(){
        return width;
    }

    public void update(int width, int height, int xCoordinate, int yCoordinate){
        this.width = width;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
        
    /**
     * toString prints attributes of Square
     * @return string of attributes in proper format
     */

    public String toString(){
        String str = super.toString();
        double width1 = width;
        str += "\nWidth: " + width;
        str += "\nCoordinates: " + "(" + xCoords[0] + "," + yCoords[0] +")";
        str += ", (" + xCoords[1] + "," +yCoords[1] +")";
        str += ", (" + xCoords[2] + "," +yCoords[2] +")";
        str += ", (" + xCoords[3] + "," +yCoords[3] +")";
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n";
        str += "\nSide 1: " + width1;
        str += "\nSide 2: " + width1;
        str += "\nSide 3: " + width1;
        str += "\nSide 4: " + width1;
        str += "\nPerimeter: " + 4 * width1;
        str += "\n====";
        return str;
    }
}