/**
 * Canvas.java
 * works on the back end of ShapeDrawGUI
 * collects information from ShapeDrawGUI to draw shapes
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;

import java.awt.event.*;
import shapes.*;

/**
 * class Canvas
 * collects information about the user's intentions
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
   
   // Variables
   private Point posStart;
   private Point posEnd;   
   private java.awt.Rectangle drawRect;
   private String shapeType;
   private boolean fillType;
   private Color c;
   private ShapeHolder sh = ShapeHolder.getInstance();
   private Shape ss = null;
   
   // Final variables
   final private Color colorSelect = new Color(0, 200, 200);
   
   // Constructors and setup methods
   /**
    * Public Canvas
    * get information from super
    * adds mouse listeners
    */
   public Canvas() {
      super();
      this.setOpaque(true);
      this.setBackground(Color.WHITE);
      c = Color.black;
      // No selection rectangle to draw
      drawRect = null;
      
      // Listen for mouse movement or input
      addMouseListener(this);      
      addMouseMotionListener(this);
   }

   /**
    * setShapeType setter
    * @param shapeType
    * sets type of shape
    */
   
   public void setShapeType(String shapeType){
      this.shapeType = shapeType;
   }

   /**
    * setColorType setter
    * @param colorType
    * sets one of the six colors
    */

   public void setColorType(String colorType){
      try {
         c = (Color) Color.class.getField(colorType).get(null);
      } catch (Exception e) {
         System.out.println("Color does not exist");
      }
   }

   /**
    * setFillType setter
    * @param fillType
    * sets to true or fals
    */

   public void setFillType(boolean fillType){
      this.fillType = fillType;
   }

   // Listeners

   /**
    * paintComponent
    * @param Graphics g
    * drawing shapes in the shape holder
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      // Draw any shapes in the shape holder here
      for(Shape shape: sh){
         drawGenericShape(g,shape);
      }
      
      // Draw drag rectangle if it is there
      
      if (drawRect != null) {
         g.setColor(colorSelect);
         g.drawRect((int)drawRect.getX(), (int)drawRect.getY(),
                    (int)drawRect.getWidth(), (int)drawRect.getHeight());
         // Draw the current shape here
         drawGenericShape(g,ss);
      }
   }
   /**
    * drawGenericShape
    * @param Graphics g
    * @param Shape s
    * designates type of shape drawn
    */
   private void drawGenericShape(Graphics g, Shape s){
      g.setColor(s.getColor());

      System.out.println(s);
      if(s.getShapeType().equals("Square")){
         Square sr = (Square) s;
            if(s.getFilled()){
               g.fillRect(sr.getXCoordinate(), sr.getYCoordinate(),sr.getWidth(), sr.getWidth());
            }
            else{
               g.drawRect(sr.getXCoordinate(), sr.getYCoordinate(),sr.getWidth(), sr.getWidth());
            }
      }
      else if(s.getShapeType().equals("Rectangle")){
         Rectangle r = (Rectangle) s;
            if(s.getFilled()){
               g.fillRect(r.getXCoordinate(), r.getYCoordinate(),r.getWidth(), r.getHeight());
            }
            else{
               g.drawRect(r.getXCoordinate(), r.getYCoordinate(),r.getWidth(), r.getHeight());
            }
      }
      // else if(s.getShapeType().equals("Triangle")){
      //    Triangle t = (Triangle) s;
      //       if(s.getFilled()){
      //          g.fillPolygon(t.getXCoords(), t.getYCoords(), 3);
      //       }
      //       else{
      //          g.drawPolygon(t.getXCoords(), t.getYCoords(), 3);
      //       }
      // }
      else if(s.getShapeType().equals("Oval")){
         Oval o = (Oval) s;
         if(s.getFilled()){
            g.fillOval(o.getXCoordinate(), o.getYCoordinate(), o.getRadius()*2, o.getRadius2()*2);
         }
         else{
            g.drawOval(o.getXCoordinate(), o.getYCoordinate(), o.getRadius()*2, o.getRadius2()*2);
         }
      }
      else if(s.getShapeType().equals("Circle")){
         Circle c = (Circle) s;
            if(s.getFilled()){
               g.fillOval( c.getXCoordinate(), c.getYCoordinate(),c.getRadius()*2, c.getRadius()*2);
            }
            else{
               g.drawOval(c.getXCoordinate(), c.getYCoordinate(),c.getRadius()*2, c.getRadius()*2);
            }
      }
   }
   
   // Needed for mouse listeners
   @Override
   public void mouseEntered(MouseEvent e) {
   }

   @Override
   public void mouseExited(MouseEvent e) {
   }
   
   @Override
   public void mouseMoved(MouseEvent e) {      
   }
   /**
    * mousePressed
    * @param MouseEvent e
    * creating new shapes from established shape selections
    * calls updateRectangle();
    */
   @Override
   public void mousePressed(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         posStart = new Point(e.getX(), e.getY());
         posEnd = new Point(e.getX(), e.getY());
         
         // Create new shape here
         if(shapeType.toLowerCase() == "rectangle"){
            ss = new Rectangle(0,0,0,0,c,fillType);
         }
         else if(shapeType.toLowerCase() == "square"){
            ss = new Square(0,0,0,c,fillType);
         }
         else if(shapeType.toLowerCase() == "circle"){
            ss = new Circle(0,0,0,c,fillType);
         }
         else if(shapeType.toLowerCase() == "triangle"){
            ss = new Triangle(0,0,0,0,c,fillType);
         }
         else if(shapeType.toLowerCase() == "oval"){
            ss = new Oval(0,0,0,0,c,fillType);
         }
         updateRectangle();    
      }
   }

   /**
    * mouseReleased
    * @param MouseEvent e
    * updates rectangle, allows setup for new shape to be drawn
    */
   @Override
   public void mouseReleased(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         posEnd.setLocation(e.getX(), e.getY());
         updateRectangle();
         
         // Add the shape to the shapeholder here
         sh.addShape(ss);
         
         // Free up the draw variables
         drawRect = null;
         posStart = null;
         posEnd = null;
         ss = (Shape) null;
         
      }
      
   }
   
   /**
    * mouseDragged
    * @param MouseEvent e
    * gets x and y coordinates of rectangle
    */

   @Override
   public void mouseDragged(MouseEvent e) {
      if (drawRect != null) {
         posEnd.setLocation(e.getX(), e.getY());
         updateRectangle();
      }
   }

   // Needed for mouse listeners

   /**
    * mouseClicked
    * @param MouseEvent e
    * allows right-click to remove the last shape
    */
   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON3) {
         sh.removeShape();
         repaint();
      }
   }

   /**
    * updateRectangle
    * sets height, width, left, and top of the rectangle for drawings
    */
   
   // Updates the selection rectangle based on the first and current mouse positions
   public void updateRectangle() {
      
      if (drawRect == null) {
         drawRect = new java.awt.Rectangle(0, 0, 0, 0);
      }
      
      int width = (int)Math.abs(posEnd.getX() - posStart.getX());
      int height = (int)Math.abs(posEnd.getY() - posStart.getY());
      int left = (int)Math.min(posStart.getX(), posEnd.getX());
      int top = (int)Math.min(posStart.getY(), posEnd.getY());
      
      // Set up rectangle to the correct four corners      
      drawRect.setLocation(left, top);
      
      drawRect.setSize(width, height);

      if(ss != null){
         ss.update((int)drawRect.getWidth(),(int)drawRect.getHeight(),(int)drawRect.getX(),(int)drawRect.getY());
      }
      
      // Let paintComponent handle this later
      repaint();
   }
}