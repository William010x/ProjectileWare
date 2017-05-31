import java.awt.*;
import javax.swing.*;

/** Animation
  * @author Tu Tran
  * @since 5/31/2017 */
public class Animation extends JComponent
{
  private double displacementY;
  private double angle;
  private int positionX = 0;
  private int positionY = 15;
  
  /** Default Constructor
   */
  public Animation()
  {
    super ();
    this.setPreferredSize(new Dimension(500,300));
    this.displacementY = Double.NaN;
  }
  
  /**  Draws a ball component
   * @overrides paintComponent
   * @param g The graphics context where the component should be drawn
   */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.scale (this.getWidth() / 50, this.getHeight() / 30);
    g2.setStroke (new BasicStroke (1.0F / this.getWidth()));
    
    //Drawing component
    if (!Double.isNaN(displacementY))
    {
      g2.setColor(Color.BLACK);
      g2.fillOval(positionX, positionY, 4, 4);
    }
  }
  
  /** Determines starting location and animates it */
  public void start()
  {
    this.repaint();
    this.moveObject();
  }
  
  /** Calls the moveVertical and moveHorizontal methods */
  private void moveObject()
  {
    while (positionX < 46 && positionY < 26)
    {
      //If object ends at same position
      if (this.displacementY == 0)
      {
        this.moveVertical();
        this.moveHorizontal();
        this.repaint();
    
        try
        {
          Thread.currentThread( ).sleep(100);
        } catch (InterruptedException ie) {
        }
      }
      
      //If object ends up higher than initial
      else if (this.displacementY > 0)
      {
        this.moveVertical();
        this.moveHorizontal();
        this.moveHorizontal();
        this.repaint();
        
        try
        {
          Thread.currentThread( ).sleep(100);
        } catch (InterruptedException ie) {
        }
      }
      
      //If object ends up lower than initial
      else
      {
        this.moveVertical();
        this.moveVertical();
        this.moveHorizontal();
        this.repaint();
        
        try
        {
          Thread.currentThread( ).sleep(100);
        } catch (InterruptedException ie) {
        }
      }
    }
  }
  
  /** Moves the ball vertically */
  private void moveVertical()
  {
    //Checks if projectile is horizontal
    if (this.angle != 0)
    {
      if (this.positionX < 23)
        positionY += 1;
      
      else
        positionY -= 1;
    }
    
    else
      positionY -= 1;
  }
  
  /** Moves the ball horizontally */
  private void moveHorizontal()
  {
    positionX++;
  }
  
  /** Sets the values for angle and displacementY */
  public void setValues(double anAngle, double aDisplacement)
  {
    this.angle = anAngle;
    this.displacementY = aDisplacement;
  }
  
  /** Clears the animation screen */
  public void reset()
  {
    this.displacementY = Double.NaN;
    this.repaint();
  }
}