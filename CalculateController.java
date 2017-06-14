//numberformatexception at line 125 if velocity1 is set to invalid before velocity2 is validated

import javax.swing.*;
import java.awt.event.*;

/** 
 * CalculateController Class
 * The controller for calculating all values (initial and final situation)
 * @author Nicolas Chatziargiriou, William San, Tu Tran
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
  
  private boolean timeB = false;
  private boolean velocity1B = false;
  private boolean velocity2B = false;
  private boolean angle1B = false;
  private boolean angle2B = false;
  private boolean displacementXB = false;
  private boolean displacementYB = false;
  private boolean errorMessage = false;   //if any error message is shown
  
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
          if (Double.parseDouble(time.getText()) > 0)
          {
            model.setTime(Double.parseDouble(time.getText()));
            timeB = true;
          }
          
          else
          {
            timeB = false;
            view.time.setText("Invalid");
            this.view.errorMessage(4);
            errorMessage = true;
          }
        }
      }
      else
        timeB = false;
      
      //Set velocity 1
      if (!velocity1.getText().equals(""))
      {
        if (validate(velocity1))
        {
          if (Double.parseDouble(velocity1.getText()) > 0)
          {
            model.setVelocity1(Double.parseDouble(velocity1.getText()));
            velocity1B = true;
          }
          
          else
          {
            velocity1B = false;
            view.velocity1.setText("Invalid");
            this.view.errorMessage(5);
            errorMessage = true;
          }
        }
      }
      else
        velocity1B = false;
      
      //Set velocity 2
      if (!velocity2.getText().equals(""))
      {
        if (validate(velocity2))
        {
          //if velocity1 exists, and is less than or equal to v2, then sets v2
          if (velocity1B && Double.parseDouble(velocity2.getText()) >= Double.parseDouble(velocity1.getText()))
          {
            model.setVelocity2(Double.parseDouble(velocity2.getText()));
            velocity2B = true;
          }
          
          else if (!velocity1B)
          {
            model.setVelocity2(Double.parseDouble(velocity2.getText()));
            velocity2B = true;
          }
          
          else
          {
            velocity2B = false;
            view.velocity2.setText("Invalid");
            this.view.errorMessage(6);
            errorMessage = true;
          }
        }
      }
      else
        velocity2B = false;
      
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
          
          else
          {
            angle1B = false;
            view.angle1.setText("Invalid");
            this.view.errorMessage(3);
            errorMessage = true;
          }
        }
      }
      else
        angle1B = false;
      
      //Set angle 2
      if (!angle2.getText().equals(""))
      {
        if (validate(angle2))
        {
          model.setAngle2(Double.parseDouble(angle2.getText()));
          angle2B = true;
        }
        
        else
        {
          angle2B = false;
          view.angle2.setText("Invalid");
        }
      }
      else
        angle2B = false;
      
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
          
          else
          {
            displacementXB = false;
            view.displacementX.setText("Invalid");
            this.view.errorMessage(2);
            errorMessage = true;
          }
        }
      }
      else
        displacementXB = false;
      
      //Set displacementY
      if (!displacementY.getText().equals(""))
      {
        if (validate(displacementY))
        {
          //Checking values exist before checking them
          if (angle1B && velocity1B)
          {
            //displacementY must be -ve if velocity1Y is negative
            if (Double.parseDouble(velocity1.getText()) * Math.sin(Math.toRadians(Double.parseDouble(angle1.getText()))) <= 0)
            {
              if (Double.parseDouble(displacementY.getText()) <= 0)
              {
                model.setDisplacementY(Double.parseDouble(displacementY.getText()));
                displacementYB = true;
              }
              
              else
              {
                displacementYB = false;
                view.displacementY.setText("Invalid");
                this.view.errorMessage(7);
                errorMessage = true;
              }
            }
            
            //if velocity1Y is not equal to or less than 0, displacementY can be any value
            else
            {
              model.setDisplacementY(Double.parseDouble(displacementY.getText()));
              displacementYB = true;
            }
          }
          
          //checking if angle1 and velocity2 exist
          else if (angle2B && velocity2B)
          {
            if (Double.parseDouble(velocity2.getText()) * Math.sin(Math.toRadians(Double.parseDouble(angle2.getText()))) == 0)
            {
              //if velocity2 is 0, displacementY must be >= 0
              if (Double.parseDouble(displacementY.getText()) >= 0)
              {
                model.setDisplacementY(Double.parseDouble(displacementY.getText()));
                displacementYB = true;
              }
              
              else
              {
                displacementYB = false;
                view.displacementY.setText("Invalid");
                this.view.errorMessage(8);
                errorMessage = true;
              }
            }
            
            //if velocity2Y is not equal to zero, displacementY can be any value
            else
            {
              model.setDisplacementY(Double.parseDouble(displacementY.getText()));
              displacementYB = true;
            }
          }
          
          //if angle1 and velocity1, and angle2 and velocity2 do not exist, sets displacementY
          else
          {
            model.setDisplacementY(Double.parseDouble(displacementY.getText()));
            displacementYB = true;
          }
        }
        
        else
        {
          displacementYB = false;
          view.displacementY.setText("Invalid");
        }
      }
      else
        displacementYB = false;
      
      //Checking how many inputs were given and valid
      int inputGiven = 0;
      inputGiven += timeB ? 1 : 0;
      inputGiven += velocity1B ? 1 : 0;
      inputGiven += velocity2B ? 1 : 0;
      inputGiven += angle1B ? 1 : 0;
      inputGiven += angle2B ? 1 : 0;
      inputGiven += displacementXB ? 1 : 0;
      inputGiven += displacementYB ? 1 : 0;
      
      if (inputGiven == 7)
        this.view.errorMessage(1);
      
      else
      {
        //Checking how many X values were given
        int xGiven = 0;
        xGiven += timeB ? 1 : 0;
        xGiven += velocity1B ? 1 : 0;
        xGiven += velocity2B ? 1 : 0;
        xGiven += angle1B ? 1 : 0;
        xGiven += angle2B ? 1 : 0;
        xGiven += displacementXB ? 1 : 0;
        
        //Checking how many Y values were given
        int yGiven = 0;
        yGiven += timeB ? 1 : 0;
        yGiven += velocity1B ? 1 : 0;
        yGiven += velocity2B ? 1 : 0;
        yGiven += angle1B ? 1 : 0;
        yGiven += angle2B ? 1 : 0;
        yGiven += displacementYB ? 1 : 0;
        
        if (!errorMessage)
        {
          if (xGiven > 2 || yGiven > 3)
          {
            model.calculate();
            view.update();
          }
        }
        
        else
          this.view.errorMessage(9);
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
      
      return false;
    }
  }
}
