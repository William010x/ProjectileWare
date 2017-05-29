import javax.swing.*;
import java.awt.*;

/** Ball Class
  * Creates component that looks like a ball
  * @since 5/29/17
  * @author William San
  */
public class Ball extends JComponent
{
  /**
    * Default Constructor
    */
  public Ball ()
  {
    super ();
    this.setPreferredSize(new Dimension(300,300));
  }
  
  /** 
    * Draws a ball component
    * @overrides paintComponent
    * @param g The graphics context where the component should be drawn
    */
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.setColor(Color.BLACK);
    g.fillOval(19,19,93,93);
    g.setColor(Color.YELLOW);
    g.fillOval(20,20,90,90); 
  }
}
