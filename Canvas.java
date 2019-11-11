import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.event.*;


public class Canvas extends JPanel implements MouseListener, MouseMotionListener {
   
   // Variables
   private Point posStart;
   private Point posEnd;   
   private Rectangle drawRect;
   
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
   
   // Listeners
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      // Draw any shapes in the shape holder here
      
      // Draw drag rectangle if it is there
      if (drawRect != null) {
         g.setColor(colorSelect);
         g.drawRect((int)drawRect.getX(), (int)drawRect.getY(),
                    (int)drawRect.getWidth(), (int)drawRect.getHeight());
         
         // Draw the current shape here
         
      }
      
   }
   
   // Highly recommended to create this method for assisting in the paintComponent method
   //private void drawGenericShape(Graphics g, GeometricShape s) {
      // Draw any sort of shape to the canvas
      
   //}
   private void drawGenericShape(Graphics g, Shape s){
      switch(s) {
         case Square:
            //Draw Square
         case Rectangle:
            //Draw Rectangle
         case Triangle:
            //Draw Triangle
         case Circle:
            //Drawn Circle
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
         
         updateRectangle();
         
        
      }
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      if (e.getButton() == MouseEvent.BUTTON1) {
         posEnd.setLocation(e.getX(), e.getY());
         updateRectangle();
         
         // Add the shape to the shapeholder here        
         
         // Free up the draw variables
         drawRect = null;
         posStart = null;
         posEnd = null;
         
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
      
      
   }
   
   // Updates the selection rectangle based on the first and current mouse positions
   public void updateRectangle() {
      
      if (drawRect == null) {
         drawRect = new Rectangle(0, 0, 0, 0);
      }
      
      int width = (int)Math.abs(posEnd.getX() - posStart.getX());
      int height = (int)Math.abs(posEnd.getY() - posStart.getY());
      int left = (int)Math.min(posStart.getX(), posEnd.getX());
      int top = (int)Math.min(posStart.getY(), posEnd.getY());
      
      // Set up rectangle to the correct four corners      
      drawRect.setLocation(left, top);
      
      drawRect.setSize(width, height);
      
      // Let paintComponent handle this later
      repaint();
   }
   
   
   
}