//Correct data validation!?

import javax.swing.*;
import java.awt.event.*;

/** 
 * CalculateController Class
 * The controller for calculating all values (initial and final situation)
 * @author William San
 * @since 6/5/17
 */ 
public class CalculateController implements ActionListener
{
  private Calculation model;         //The Model used for numbers and calculations
  private GUI view;                  //The view containing the animation and textfields
  private JTextField time;           //The time of the projectile motion (s)
  private JTextField velocity1;      //The inital speed of the projectile (m/s)
  private JTextField velocity2;      //The final speed of the projectile (m/s)
  private JTextField angle1;         //The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  private JTextField angle2;         //The final velocity's angle above or below the horizontal (above +, below -) (degrees)
  private JTextField displacementX;  //The horizontal displacement of the projectile (m)
  private JTextField displacementY;  //The vertical displacement of the projectile (m)
  
  private boolean invalidInput = false;  //if any inputs are invalid
  
  private boolean timeB = false;
  private boolean velocity1B = false;
  private boolean velocity2B = false;
  private boolean angle1B = false;
  private boolean angle2B = false;
  private boolean displacementXB = false;
  private boolean displacementYB = false;
  
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
  public CalculateController(Calculation aModel, GUI aView, JTextField t, JTextField v1, JTextField v2, JTextField theta1, JTextField theta2, JTextField dX, JTextField dY)
  {
    this.model = aModel;
    this.view = aView;
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
    int inputGiven = 0;    //number of inputs given
    
    //Checks if button pressed was the "Start" button
    if (((JButton) e.getSource()).getText().equals("Start"))
    {
      this.view.runAnimation();
    }
    
    //Else, calculates the empty text fields
    else
    {
      //Set time
      if (!time.getText().equals(""))
      {
        if (validate(time))
        {
          model.setTime(Double.parseDouble(time.getText()));
          timeB = true;
          inputGiven++;
        }
        
        else
          view.time.setText("Invalid");
      }
      //Set velocity 1
      if (!velocity1.getText().equals(""))
      {
        if (validate(velocity1))
        {
          model.setVelocity1(Double.parseDouble(velocity1.getText()));
          velocity1B = true;
          inputGiven++;
        }
        
        else
          view.velocity1.setText("Invalid");
      }
      //Set velocity 2
      if (!velocity2.getText().equals(""))
      {
        if (validate(velocity2))
        {
          model.setVelocity2(Double.parseDouble(velocity2.getText()));
          velocity2B = true;
          inputGiven++;
        }
        
        else{
          view.velocity2.setText("Invalid");
          invalidInput = true;
      }
      }
      
      //Set angle 1
      if (!angle1.getText().equals(""))
      {
        if (validate(angle1))
        {
          if (Double.parseDouble(angle1.getText()) <= 90 && Double.parseDouble(angle1.getText()) >= 0)
          {
            angle1B = true;
            model.setAngle1(Double.parseDouble(angle1.getText()));
          }
          
          inputGiven++;
        }
        
        else{
          view.angle1.setText("Invalid");
          invalidInput = true;
      }
      }
      //Set angle 2
      if (!angle2.getText().equals(""))
      {
        if (validate(angle2))
        {
          model.setAngle2(Double.parseDouble(angle2.getText()));
          angle2B = true;
          inputGiven++;
        }
        
        else{
          view.angle2.setText("Invalid");
          invalidInput = true;
      }
      }
      //Set displacementX
      if (!displacementX.getText().equals(""))
      {
        if (validate(displacementX))
        {
          if (Double.parseDouble(displacementX.getText()) > 0)
          {
            displacementXB = true;
            model.setDisplacementX(Double.parseDouble(displacementX.getText()));
          }
          
          inputGiven++;
        }
        
        else{
          view.displacementX.setText("Invalid");
          invalidInput = true;
      }
      }
      //Set displacementY
      if (!displacementY.getText().equals(""))
      {
        if (validate(displacementY))
        {
          model.setDisplacementY(Double.parseDouble(displacementY.getText()));
          displacementYB = true;
          inputGiven++;
        }
        
        else{
          view.displacementY.setText("Invalid");
          invalidInput = true;
      }
      }
      
      if (!invalidInput && inputGiven != 7)
      {
        model.calculate();
        view.update();
      }
      
      else
      {
        if (inputGiven == 7)
          this.view.errorMessage(1);
        
        else if (!displacementXB && !displacementX.getText().equals(""))
          this.view.errorMessage(2);
        
        else if (!angle1B && !angle1.getText().equals(""))
          this.view.errorMessage(3);
        
        else
          this.view.errorMessage(4);
      }
    }
 }
    
    /* Data validation for textField inputs */
    private boolean validate(JTextField input)
    {
      try{
        Double.parseDouble(input.getText());
        return true;
      } catch (NumberFormatException e)
      {
        invalidInput = true;
        return false;
      }
    }
  }
