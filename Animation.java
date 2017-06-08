/** To do:
 * Scale drawing in event that it goes beyond borders
 * 
 * Possibly:
 * draw arc showing complete path of projectile
 */

import java.awt.*;
import javax.swing.*;

/** Animation
  * @author Tu Tran
  * @since 6/5/2017 */
public class Animation extends JComponent
{
private Calculation model;
  private int positionX;
  private int positionY;
  
  /** Default Constructor
   */
  public Animation(Calculation aModel)
  {
    super ();
    this.setPreferredSize(new Dimension(100,250));
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
    g.fillOval(0 + positionX, 125 + positionY, 20, 20);
   }
  
  /** Calls the moveVertical and moveHorizontal methods */
  public void start()
  {
    //Moves object in 0.1 sec increments until the maximum time value is reached
    for (double t = 0; t < this.model.getTime(); t += 0.01)
    {
      moveHorizontal(t);
      moveVertical(t);
      repaint();
      
      try
      {
        Thread.currentThread( ).sleep(2);
      } catch (InterruptedException ie) {
      }
    }
  }
  
  /** Calculates the object's new horizontal position
    * @param       the current time at object's position */
  private void moveHorizontal(double time)
  {
    this.positionY = (int)((this.model.getVelocity1() * Math.sin(Math.toRadians(this.model.getAngle1())) * time) + (0.5 * -9.81 * Math.pow(time, 2)));
  }
  
  /** Calculates the object's new vertical position
    * @param       the current time at object's position */
  private void moveVertical(double time)
  {
    this.positionX = (int)(this.model.getVelocity1() * Math.cos(Math.toRadians(this.model.getAngle1())) * time);
  }
  
  /** Clears the animation screen */
  public void reset()
  {
    repaint();
  }
}
