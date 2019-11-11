import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

      ActionListener square_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setShapeType("square");
         }
      };

      ActionListener circle_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setShapeType("circle");
         }
      };

      ActionListener triangle_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setShapeType("triangle");
         }
      };

      ActionListener rectangle_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setShapeType("rectangle");
         }
      };

      ActionListener red_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("red");
         }
      };

      ActionListener blue_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("blue");
         }
      };

      ActionListener green_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("green");
         }
      };

      ActionListener yellow_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("yellow");
         }
      };

      ActionListener magenta_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("magenta");
         }
      };

      ActionListener cyan_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setColorType("cyan");
         }
      };

      ActionListener fill_bl = new ActionListener(){
         public void actionPerformed(ActionEvent e) {
            canvas.setFillType(fillButton.isSelected());
         }
      };

      positionConst.gridy=1;
      positionConst.gridwidth = 1;

      positionConst.gridx=1;
      add(squareButton,positionConst);
      squareButton.addActionListener(square_bl);
      

      positionConst.gridx=2;
      add(rectangleButton,positionConst);
      rectangleButton.addActionListener(rectangle_bl);

      positionConst.gridx=3;
      add(triangleButton,positionConst);
      triangleButton.addActionListener(triangle_bl);

      positionConst.gridx=4;
      add(circleButton,positionConst);
      circleButton.addActionListener(circle_bl);

      positionConst.gridx=5;
      add(fillButton,positionConst);
      fillButton.addActionListener(fill_bl);

      positionConst.gridy=2;

      positionConst.gridx=1;
      add(redButton,positionConst);
      redButton.addActionListener(red_bl);

      positionConst.gridx=2;
      add(blueButton,positionConst);
      blueButton.addActionListener(blue_bl);

      positionConst.gridx=3;
      add(greenButton,positionConst);
      greenButton.addActionListener(green_bl);

      positionConst.gridx=4;
      add(cyanButton,positionConst);
      cyanButton.addActionListener(cyan_bl);

      positionConst.gridx=5;
      add(magentaButton,positionConst);
      magentaButton.addActionListener(magenta_bl);

      positionConst.gridx=6;
      add(yellowButton,positionConst);
      yellowButton.addActionListener(yellow_bl);
   }
   
   public static void main(String[] args) {
       
      // Main frame
      ShapeDrawGUI appFrame = new ShapeDrawGUI();                
      
      // Show window
      appFrame.setVisible(true);
   }
}