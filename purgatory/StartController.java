import javax.swing.*;
import java.awt.event.*;

/** StartController class
  * Operates the operation buttons
  * @since 6/5/2017
  * @author Nicolas Chatziargilliou
  */
public class StartController implements ActionListener
{
   /** 
   * Default constructor
   * Links the component to the Model
   */ 
  public StartController()
  {
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
