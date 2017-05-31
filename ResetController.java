import javax.swing.*;
import java.awt.event.*;

/** 
 * ResetController Class
 * The controller for the reset button (to clear all values)
 * @author William San
 * @since 5/31/17
 */ 
public class ResetController implements ActionListener
{
  private Calculation model;         //The Model storing all numbers
  
  /** 
   * Default constructor
   * Links model to Reset button
   * @param aModel The Model storing all the numbers
   */ 
  public ResetController(Calculation model)
  {
    this.model = aModel;
  }
  
  /** 
   * Resets all input boxes
   * @param e The event sent from the button
   */
  public void actionPerformed(ActionEvent e)
  {
    this.model.reset();
  }
}