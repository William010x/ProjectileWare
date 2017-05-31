import javax.swing.*;

/** 
 * StartUp Class
 * Creates a projectile motion simulator
 * @author William San
 * @since 5/18/17
 */ 
public class StartUp
{
  //Instance Variables
  Calculation model;  //The simulator model for calculations
  GUI view;           //The simulator view for display
  
  /** 
   * Main method
   * @param args An array of commands that can be used on startup
   */
  public static void main (String [] args)
  {
    //Initialize the Frame
    JFrame frame = new JFrame("Projectile Motion Simulator");
    frame.pack();
    frame.setLocation(100,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(view);
    frame.setVisible(true);
  }
}
