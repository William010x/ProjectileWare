/** To do:
 * Implement calculation class methods to get values
 * Scale drawing in event that it goes beyond borders
 * Testing of class
 * 
 * Possibly:
 * draw arc showing complete path of projectile
 */

import java.awt.*;
import javax.swing.*;

/** Animation
  * @author Tu Tran
  * @since 6/3/2017 */
public class Animation extends JComponent
{
  //private Calculation model;
  private int positionX;
  private int positionY;
  
  /** Default Constructor
   */
  public Animation(/*Calculation aModel*/)
  {
    super ();
    this.setPreferredSize(new Dimension(500,300));
    this.model = aModel;
  }
  
  /** Draws component
   * @overrides paintComponent
   * @param g The graphics context where the component should be drawn
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.setColor(Color.BLACK);
    g.fillOval(0 + positionX, 150 + positionY, 5, 5);
  }
  
  /** Calls the moveVertical and moveHorizontal methods */
  private void moveObject()
  {
    for (double t = 0; t < this.model.getTime(); t += 0.1)
    {
      moveHorizontal(t);
      moveVertical(t);
      repaint();
      
      try
      {
        Thread.currentThread( ).sleep(100);
      } catch (InterruptedException ie) {
      }
    }
  }
  
  /** Calculates the object's new horizontal position
    * @param       the current time at object's position */
  private void moveHorizontal(double time)
  {
    this.positionY = (int)((Math.sin(this.model.getVelocity()) * time) + (0.5 * -9.81 * Math.pow(time, 2)));
  }
  
  /** Calculates the object's new vertical position
    * @param       the current time at object's position */
  private void moveVertical(double time)
  {
    this.positionX = (int)(Math.cos(this.model.getVelocity()) * time);
  }
  
  /** Clears the animation screen */
  public void reset()
  {
    repaint();
  }
}