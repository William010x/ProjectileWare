//package SwingExample;
import javax.swing.*;
import java.awt.event.*;

/** 
 * CalculateController Class
 * The controller for calculating all values (initial and final situation)
 * @author William San
 * @since 5/18/17
 */ 
public class CalculateController implements ActionListener
{
  private Calculation model;         //The Model used for numbers and calculations
  private JTextField time;           //The time of the projectile motion
  private JTextField velocity1;      //The inital speed of the projectile
  private JTextField velocity2;      //The final speed of the projectile
  private JTextField angle1;         //The inital velocity's angle above or below the horizontal (degrees) (above +, below -)
  private JTextField angle2;         //The final velocity's angle above or below the horizontal (degrees) (above +, below -)
  private JTextField displacementX;  //The horizontal displacement of the projectile
  private JTextField displacementY;  //The vertical displacement of the projectile
  
  private boolean timeB;
  private boolean velocity1B;
  private boolean velocity2B;
  private boolean angle1B;
  private boolean angle2B;
  private boolean displacementXB;
  private boolean displacementYB;
  
  /** 
   * Default constructor
   * Links the component to the Model
   * @param aModel The Model for numbers and calculations
   * @param button The component being interacted with
   */ 
  public CalculateController(Calculation model, JTextField t, JTextField v1, JTextField v2, JTextField theta1, JTextField theta2, JTextField dX, JTextField dY)
  {
    this.model = aModel;
    this.time = aTime;
    this.velocity1 = v1;
    this.velocity2 = v2;
    this.angle1 = theta1;
    this.angle2 = theta2;
    this.displacementX = dX;
    this.displacementY = dY;
  }
  
  /** 
   * Calculates all values (initial and final situation)
   * @param e The event sent from the button
   */
  public void actionPerformed(ActionEvent e)
  {
    //Set time
    if (!time.getText().equals(""))
    {
      model.setTime(time.getText());
    }
    //Set velocity 1
    if (!velocity1.getText().equals(""))
    {
      model.setVelocity1(velocity1.getText());
    }
    //Set velocity 2
    if (!velocity2.getText().equals(""))
    {
      model.setVelocity2(velocity2.getText());
    }
    //Set angle 1
    if (!angle1.getText().equals(""))
    {
      model.set(angle1.getText());
    }
    //Set angle 2
    if (!angle2.getText().equals(""))
    {
      model.setAngle2(angle2.getText());
    }
    //Set displacementX
    if (!displacementX.getText().equals(""))
    {
      model.setDisplacementX(displacementX.getText());
    }
    //Set displacementY
    if (!displacementY.getText().equals(""))
    {
      model.setDisplacementY(displacementY.getText());
    }
  }
}
