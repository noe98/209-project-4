import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;

import javafx.scene.shape.Circle;
import shapes.Square;

import java.awt.event.*;
import shapes.*;


public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
   
   // Variables
   private Point posStart;
   private Point posEnd;   
   private java.awt.Rectangle drawRect;
   private String shapeType;
   private String colorType;
   private boolean fillType;
   private Color c;
   private ShapeHolder sh = ShapeHolder.getInstance();
   private Shape ss = null;
   
   // Final variables
   final private Color colorSelect = new Color(0, 200, 200);
   
   // Constructors and setup methods
   public Canvas() {
      super();
      this.setOpaque(true);
      this.setBackground(Color.WHITE);
      
      // No selection rectangle to draw
      drawRect = null;
      
      // Listen for mouse movement or input
      addMouseListener(this);      
      addMouseMotionListener(this);
      
      
   }
   
   public void setShapeType(String shapeType){
      this.shapeType = shapeType;
   }

   public void setColorType(String colorType){
      c = (Color) Color.class.getField(colorType).get(null);
   }

   public void setFillType(boolean fillType){
      this.fillType = fillType;
   }

   // Listeners
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
   
   private void drawGenericShape(Graphics g, Shape s){
      g.setColor(c);
      if(s.getShapeType().equals("Square")){
         Square sr = (Square) s;
            if(fillType){
               g.fillRect(sr.getWidth(), sr.getWidth(), sr.getXCoordinate(), sr.getYCoordinate());
            }
            else{
               g.drawRect(sr.getWidth(), sr.getWidth(), sr.getXCoordinate(), sr.getYCoordinate());
            }
      }
      else if(s.getShapeType().equals("Rectangle")){
         Rectangle r = (Rectangle) s;
            if(fillType){
               g.fillRect(r.getWidth(), r.getHeight(), r.getXCoordinate(), r.getYCoordinate());
            }
            else{
               g.drawRect(r.getWidth(), r.getHeight(), r.getXCoordinate(), r.getYCoordinate());
            }
      }
      else if(s.getShapeType().equals("Triangle")){
         Triangle t = (Triangle) s;
            if(fillType){
               g.fillPolygon(t.getXCoords(), t.getYCoords(), 3);
            }
            else{
               g.drawPolygon(t.getXCoords(), t.getYCoords(), 3);
            }
      }
      else if(s.getShapeType().equals("Circle")){
         Circle c = (Circle) s;
            if(fillType){
               g.fillOval(c.getRadius()*2, c.getRadius()*2, c.getXCoordinate(), c.getYCoordinate());
            }
            else{
               g.drawOval(c.getRadius()*2, c.getRadius()*2, c.getXCoordinate(), c.getYCoordinate());
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
   
   @Override
   public void mousePressed(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         posStart = new Point(e.getX(), e.getY());
         posEnd = new Point(e.getX(), e.getY());
         
         // Create new shape here

         switch (shapeType){
            case "rectangle":
               ss = new Rectangle(drawRect.getWidth(),drawRect.getHeight(),drawRect.getXCoordinate(),drawRect.getYCoordinate(),c,fillType);
            case "square":
               ss = new Square(drawRect.getWidth(),drawRect.getXCoordinate(),drawRect.getYCoordinate(),c,fillType);
            case "circle":
               ss = new Circle((drawRect.getWidth()/2),drawRect.getXCoordinate(),drawRect.getYCoordinate(),c,fillType);
            case "triangle":
               ss = new Triangle(drawRect.getWidth(),drawRect.getHeight(),drawRect.getXCoordinate(),drawRect.getYCoordinate(),c,fillType);
         }

         
         updateRectangle();
         
        
      }
   }

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
         ss = null;
         
      }
      
   }
   
   @Override
   public void mouseDragged(MouseEvent e) {
      if (drawRect != null) {
         posEnd.setLocation(e.getX(), e.getY());
         updateRectangle();
      }
   }



   // Needed for mouse listeners
   @Override
   public void mouseClicked(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON3) {
         sh.removeShape();
         repaint();
      }
   }
   
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
         ss.update(drawRect.getWidth(),drawRect.getHeight(),drawRect.getXCoordinate(),drawRect.getYCoordinate());
      }
      
      // Let paintComponent handle this later
      repaint();
   }
   
   
   
}