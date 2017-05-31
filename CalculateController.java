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
  private JTextField time;           //The time of the projectile motion (s)
  private JTextField velocity1;      //The inital speed of the projectile (m/s)
  private JTextField velocity2;      //The final speed of the projectile (m/s)
  private JTextField angle1;         //The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  private JTextField angle2;         //The final velocity's angle above or below the horizontal (above +, below -) (degrees)
  private JTextField displacementX;  //The horizontal displacement of the projectile (m)
  private JTextField displacementY;  //The vertical displacement of the projectile (m)
  
  //private boolean timeB;
  //private boolean velocity1B;
  //private boolean velocity2B;
  //private boolean angle1B;
  //private boolean angle2B;
  //private boolean displacementXB;
  //private boolean displacementYB;
  
  /** 
   * Default constructor
   * Links the component to the Model
   * @param aModel The Model for numbers and calculations
   * @param t Time of projectile motion (s)
   * @param v1 Initial velocity (m/s)
   * @param v2 Final velocity (m/s)
   * @param theta1 Iniital velocity's angle (above horizontal +, below horizontal -) (degrees)
   * @param theta2 Final velocity's angle (above horizontal +, below horizontal -) (degrees)
   * @param dX Horizontal displacement of the projectile (m)
   * @param dY Vertical displacement of the projectile (m)
   */ 
  public CalculateController(Calculation aModel, JTextField t, JTextField v1, JTextField v2, JTextField theta1, JTextField theta2, JTextField dX, JTextField dY)
  {
    this.model = aModel;
    this.time = t;
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
      model.setTime(Double.parseDouble(time.getText()));
    }
    //Set velocity 1
    if (!velocity1.getText().equals(""))
    {
      model.setVelocity1(Double.parseDouble(velocity1.getText()));
    }
    //Set velocity 2
    if (!velocity2.getText().equals(""))
    {
      model.setVelocity2(Double.parseDouble(velocity2.getText()));
    }
    //Set angle 1
    if (!angle1.getText().equals(""))
    {
      model.setAngle1(Double.parseDouble(angle1.getText()));
    }
    //Set angle 2
    if (!angle2.getText().equals(""))
    {
      model.setAngle2(Double.parseDouble(angle2.getText()));
    }
    //Set displacementX
    if (!displacementX.getText().equals(""))
    {
      model.setDisplacementX(Double.parseDouble(displacementX.getText()));
    }
    //Set displacementY
    if (!displacementY.getText().equals(""))
    {
      model.setDisplacementY(Double.parseDouble(displacementY.getText()));
    }
  }
}
