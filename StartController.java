import javax.swing.*;
import java.awt.event.*;

/** StartController class
  * Operates the operation buttons
  * @since 5/29/2017
  * @author Nicolas Chatziargilliou
  */
public class StartController implements ActionListener
{
  private JTextField angle;          //Initial velocity's angle above or below the horizontal (above +, below -) (degrees)
  private JTextField displacementY;  //Vertical displacement of projectile (m)
  
   /** 
   * Default constructor
   * Links the component to the Model
   * @param theta1 Iniital velocity's angle (above horizontal +, below horizontal -) (degrees)
   * @param dY Vertical displacement of the projectile (m)
   */ 
  public StartController(JTextField theta, JTextField dY)
  {
    this.angle = theta;
    this.displacementY = dY;
  }
  
  /** 
   * Calculates all values (initial and final situation)
   * @param e The event sent from the button
   */
  public void actionPerformed(ActionEvent e)
  {
    Animation.start();
  }
}
