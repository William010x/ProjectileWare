import javax.swing.*;

/** Startup
  * the startup program
  * @author Tu Tran
  * @since 5/19/2017 */
public class Startup
{
  public static void main(String[] args)
  {
    //Calculation model;  //the model
    GUI view = new GUI();  //the view
    JFrame main = new JFrame();
    
    main.setTitle("Physics Pro");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setContentPane(view);
    main.pack();
    main.setVisible(true);
  }
}