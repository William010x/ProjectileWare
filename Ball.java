import javax.swing.*;
import java.awt.*;
public class Ball extends JComponent
{
  public Ball ()
  {
    super ();
    this.setPreferredSize(new Dimension(300,300));
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
  
    //head
    g.setColor(Color.BLACK);
    g.fillOval(19,19,93,93);
    g.setColor(Color.YELLOW);
    g.fillOval(20,20,90,90);
    
    

  }
  
  
}      

