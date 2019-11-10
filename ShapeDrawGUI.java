import javax.swing.*;
import java.awt.*;

public class ShapeDrawGUI extends JFrame {
    
   // Class Variables  
   private Canvas canvas;
      
   public ShapeDrawGUI() {
      
      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      GridBagConstraints positionConst = new GridBagConstraints();
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Set up the window
      setSize(1100,800);
      setTitle("Draw Shapes");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Add the canvas
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      positionConst.fill = GridBagConstraints.BOTH;
      positionConst.gridwidth = GridBagConstraints.REMAINDER;
      positionConst.weightx = 1;
      positionConst.weighty = 1;
      
      canvas = new Canvas();        
      add(canvas, positionConst);
      
      positionConst.fill = GridBagConstraints.HORIZONTAL;
      positionConst.gridwidth = 1;
      positionConst.gridy = 1;
      positionConst.weighty = 0;
      
      // Add buttons and checkboxes below the canvas here
      JButton squareButton = new JButton("Square");
      JButton circleButton = new JButton("Cirlce");
      JButton triangleButton = new JButton("Triangle");
      JButton rectangleButton = new JButton("Rectangle");
      JCheckBox fillButton = new JCheckBox("Fill?");
      JButton redButton = new JButton("Red");
      JButton blueButton = new JButton("Blue");
      JButton greenButton = new JButton("Green");
      JButton yellowButton = new JButton("Yellow");
      JButton magentaButton = new JButton("Magenta");
      JButton cyanButton = new JButton("Cyan");

      positionConst.gridy=1;
      positionConst.gridwidth = 1;

      positionConst.gridx=1;
      add(squareButton,positionConst);

      positionConst.gridx=2;
      add(rectangleButton,positionConst);

      positionConst.gridx=3;
      add(triangleButton,positionConst);

      positionConst.gridx=4;
      add(circleButton,positionConst);

      positionConst.gridx=5;
      add(fillButton,positionConst);

      positionConst.gridy=2;

      positionConst.gridx=1;
      add(redButton,positionConst);

      positionConst.gridx=2;
      add(blueButton,positionConst);

      positionConst.gridx=3;
      add(greenButton,positionConst);

      positionConst.gridx=4;
      add(cyanButton,positionConst);

      positionConst.gridx=5;
      add(magentaButton,positionConst);

      positionConst.gridx=6;
      add(yellowButton,positionConst);
   }
   
   public static void main(String[] args) {
       
      // Main frame
      ShapeDrawGUI appFrame = new ShapeDrawGUI();                
      
      // Show window
      appFrame.setVisible(true);
   }
}