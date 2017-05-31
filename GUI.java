import javax.swing.*;
import java.awt.*;

/** GUI Class
  * @author Tu Tran
  * @since 5/18/2017 */
public class GUI extends JPanel
{
  Calculation model;
  
  JTextField velocity1;       //display/entry for initial velocity
  JTextField velocity2;       //display/entry for final velocity
  JTextField angle;           //display/entry for initial angle
  JTextField time;            //display/entry for time
  JTextField displacementX;   //display/entry for final horizontal displacement
  JTextField displacementY;   //display/entry for final vertical displacement
  
  JButton start;              //the start button
  JButton calculate;          //the calculate button
  JButton reset;              //the reset button
  //Animation screen;           //the animation of the problem
  JPanel input;               //panel containing input fields
  JPanel buttonPanel;         //panel containing the buttons
  
  /* Constructor
   * @param aModel    The calculation model */
  public GUI(Calculation aModel)
  {
    super();
    this.model = aModel;
    this.model.setGUI(this);
    //this.screen = aScreen;
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  /* Lays out the components on the JPanel */
  private void layoutView()
  {
    //Initializing components
    JTextArea filler = new JTextArea(10, 50);
    JLabel blank = new JLabel();
    
    velocity1 = new JTextField(10);
    velocity2 = new JTextField(10);
    angle = new JTextField(10);
    time = new JTextField(10);
    displacementX = new JTextField(10);
    displacementY = new JTextField(10);
    
    start = new JButton("Start");
    calculate = new JButton("Calculate");
    reset = new JButton("Reset");
    input = new JPanel();
    buttonPanel = new JPanel();
    
    //Setting layouts
    BorderLayout layout = new BorderLayout();
    GridLayout layout2 = new GridLayout(3, 2);
    GridLayout layout3 = new GridLayout(2, 1);
    this.setLayout(layout);
    input.setLayout(layout2);
    buttonPanel.setLayout(layout3);

    //Setting borders
    velocity1.setBorder(BorderFactory.createTitledBorder("Initial Velocity"));
    velocity2.setBorder(BorderFactory.createTitledBorder("Impact Velocity"));
    angle.setBorder(BorderFactory.createTitledBorder("Initial Angle"));
    time.setBorder(BorderFactory.createTitledBorder("Time"));
    displacementX.setBorder(BorderFactory.createTitledBorder("Displacement X"));
    displacementY.setBorder(BorderFactory.createTitledBorder("Displacement Y"));
    
    input.setBorder(BorderFactory.createEtchedBorder());
    buttonPanel.setBorder(BorderFactory.createEtchedBorder());
    
    //Setting sizes
    start.setPreferredSize(new Dimension(100, 25));
    calculate.setPreferredSize(new Dimension(100, 25));
    blank.setPreferredSize(new Dimension(100, 25));
    filler.setEnabled(false);
    
    //Adding components
    input.add(velocity1);
    input.add(velocity2);
    input.add(angle);
    input.add(time);
    input.add(displacementX);
    input.add(displacementY);
    
    buttonPanel.add(start);
    buttonPanel.add(reset);
    buttonPanel.add(calculate);
    
    this.add(filler, BorderLayout.NORTH);
    this.add(input, BorderLayout.WEST);
    this.add(blank, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.EAST);
    //this.add(screen, BorderLayout.NORTH);
  }
  
  /* Registers the controllers for text fields and buttons */
  private void registerControllers()
  {
  }
  
  /* Updates the animation and text fields after calculations */
  public void update()
  {
  }
}
