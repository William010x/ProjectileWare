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
  
  /** Calculates the object's new horizontal position
    * @param       the current time at object's position */
  public void moveVertical(double time)
  {
    this.positionY = (int)Math.round(-((this.model.getVelocity1() * Math.sin(Math.toRadians(this.model.getAngle1())) * time) + (0.5 * -9.81 * Math.pow(time, 2))));
    this.paintImmediately(0, 0, 600, 400);
  }
  
  /** Calculates the object's new vertical position
    * @param       the current time at object's position */
  public void moveHorizontal(double time)
  {
    this.positionX = (int)Math.round((this.model.getVelocity1() * Math.cos(Math.toRadians(this.model.getAngle1())) * time));
    this.paintImmediately(0, 0, 600, 400);
  }
  
  /** Clears the animation screen */
  public void reset()
  {
    this.positionX = 0;
    this.positionY = 0;
    this.paintImmediately(0, 0, 600, 400);
  }
}
