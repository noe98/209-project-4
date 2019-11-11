package shapes;
/**
 * @author Elyssa McMaster
 * Octagon.java
 * This file creates a string with attributes of a given octagon
 */

public class Octagon extends Shape{
    private int[] xCoords;
    private int[] yCoords;
    private int width;
    private int height;



    // methods to find initial x coord, y coord, fill, 
    // and color have already been included in the class
    // this one inheirits from

    /**
     * 
     *  Octagon Constructor 
     * 
     * @param width: width of square within which the octagon is drawn
     * @param height: height of square within which the octagon is drawn
     * @param xCoordinate: starting x-position of the drawing of the octagon
     * @param yCoordinate: starting y-position of the drawing of the octagon
     * @param color: color of the shape
     * @param filled: whether the shape is filled in or the color is just for the outline
     */
    public Octagon(int width, int height, int xCoordinate, int yCoordinate, String color, boolean filled){
        super(xCoordinate, yCoordinate, color, filled);
        this.width = width; 
        this.height = height;

        xCoords = new int[8];
        xCoords[0]= xCoordinate;        // add x coordinates to array
        xCoords[1]= (xCoordinate + ((width/3)));
        xCoords[2]= xCoordinate + ((2*width)/3);
        xCoords[3]= xCoordinate + ((2*width)/3);
        xCoords[4] = xCoordinate + ((width)/3);
        xCoords[5] = xCoordinate + width;
        xCoords[6] = xCoordinate - (width/3);;
        xCoords[7] = xCoordinate - (width/3);
    
        yCoords = new int[8];       // add y coordinates to a different array
        yCoords[0]= yCoordinate;
        yCoords[1]=yCoordinate;
        yCoords[2]=yCoordinate - (height/3);
        yCoords[3] = yCoordinate - ((2*height)/3);
        yCoords[4]= yCoordinate - height;
        yCoords[5]= yCoordinate - height;
        yCoords[6]= yCoordinate - ((2 *height)/3);
        yCoords[7]= yCoordinate - (height/3);
            
        shapeType = "Octagon";
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
     * toString prints attributes of Octagon
     * @return string of attributes in proper format
     */
    public String toString(){

        String str = super.toString();
        str += "\nWidth: " + width;
        str += "\nHeight: " + height;
        str += "\nCoordinates: " + "(" +xCoords[0] + "," + yCoords[0] +")";
        str += ", (" + xCoords[1] + "," +yCoords[1] +")";
        str += ", (" + xCoords[2] + "," +yCoords[2] +")";
        str += ", (" + xCoords[3] + "," +yCoords[3] +")";
        str += ", (" + xCoords[4] + "," +yCoords[4] +")";
        str += ", (" + xCoords[5] + "," +yCoords[5] +")";
        str += ", (" + xCoords[6] + "," +yCoords[6] +")";
        str += ", (" + xCoords[7] + "," +yCoords[7] +")";
        str += "\nPosition: " + xCoordinate + ", " + yCoordinate;
        str += "\nFiled: " + filled;
        str += "\nColor: " + color;
        str += "\n";
        // side calculations (based on the square which the octagon is placed in)
        double width1 = (double) width/3;
        double height1 = (double) height/3;
        double pow = Math.sqrt(Math.pow(height1,2) + Math.pow(width1, 2));
        str += "\nSide 1: " + (width1);
        str += "\nSide 2: " + pow;
        str += "\nSide 3: " + (height1);
        str += "\nSide 3: " + (height1);
        str += "\nSide 4: " + pow;
        str += "\nSide 5: " + (width1);
        str += "\nSide 6: " + pow;
        str += "\nSide 7: " + (height1);
        str += "\nSide 8: " + pow; 
        double calc = ((Math.pow((height1), 2.0)) + Math.pow(width1, 2));
        calc = Math.sqrt(calc);
        str += "\nPerimeter: " + ((2 * width1) + (2 * width1) + (4 * calc)); 
        str += "\n====";
        return str;

       
    }
}