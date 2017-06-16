import javax.swing.*;
import java.awt.*;

/** GUI Class
  * @author Tu Tran
  * @since 6/5/2017 */
public class GUI extends JPanel
{
  Calculation model;
  
  static JFrame error = new JFrame();  //frame for displaying errorPane
  JTextField velocity1;       //display/entry for initial velocity
  JTextField velocity2;       //display/entry for final velocity
  JTextField angle1;          //display/entry for initial angle
  JTextField angle2;          //display/entry for impact angle
  JTextField time;            //display/entry for time
  JTextField displacementX;   //display/entry for final horizontal displacement
  JTextField displacementY;   //display/entry for final vertical displacement
  
  JButton start;              //the start button
  JButton calculate;          //the calculate button
  JButton reset;              //the reset button
  static JOptionPane errorPane;  //optionPane showing error message
  Animation screen;           //the animation of the problem
  JPanel input;               //panel containing input fields
  JPanel buttonPanel;         //panel containing the buttons
  public static boolean blank = true; // variable for setting textfields
  
  /* Constructor
   * @param aModel    The calculation model */
  public GUI(Calculation aModel)
  {
    super();
    this.model = aModel;
    this.model.setGUI(this);
    this.layoutView();
    this.registerControllers();
    this.update();
  }
  
  /* Lays out the components on the JPanel */
  private void layoutView()
  {
    //Initializing components
    JLabel blank = new JLabel();
    
    screen = new Animation(model);
    velocity1 = new JTextField(10);
    velocity2 = new JTextField(10);
    angle1 = new JTextField(10);
    angle2 = new JTextField(10);
    time = new JTextField(10);
    displacementX = new JTextField(10);
    displacementY = new JTextField(10);
    
    start = new JButton("Start");
    calculate = new JButton("Calculate");
    reset = new JButton("Reset");
    errorPane = new JOptionPane();
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
    angle1.setBorder(BorderFactory.createTitledBorder("Initial Angle"));
    angle2.setBorder(BorderFactory.createTitledBorder("Impact Angle"));
    time.setBorder(BorderFactory.createTitledBorder("Time"));
    displacementX.setBorder(BorderFactory.createTitledBorder("Displacement X"));
    displacementY.setBorder(BorderFactory.createTitledBorder("Displacement Y"));
    
    input.setBorder(BorderFactory.createEtchedBorder());
    buttonPanel.setBorder(BorderFactory.createEtchedBorder());
    
    //Setting sizes
    start.setPreferredSize(new Dimension(100, 25));
    calculate.setPreferredSize(new Dimension(100, 25));
    blank.setPreferredSize(new Dimension(100, 25));
    
    //Adding components
    input.add(velocity1);
    input.add(angle1);
    input.add(displacementX);
    input.add(velocity2);
    input.add(angle2);
    input.add(displacementY);
    input.add(time);
    
    buttonPanel.add(start);
    buttonPanel.add(reset);
    buttonPanel.add(calculate);
    
    error.add(errorPane);
    
    this.add(input, BorderLayout.WEST);
    this.add(blank, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.EAST);
    this.add(screen, BorderLayout.NORTH);
  }
  
  /* Registers the controllers for text fields and buttons */
  private void registerControllers()
  {
    CalculateController controller1 = new CalculateController(this.model, this, this.time, this.velocity1, this.velocity2, this.angle1, this.angle2, this.displacementX, this.displacementY);
    ResetController controller2 = new ResetController(this.model);
    
    this.start.addActionListener(controller1);
    this.calculate.addActionListener(controller1);
    this.reset.addActionListener(controller2);
  }
  
  /* Runs the animation of the problem */
  public void runAnimation()
  {
    //Moves object in 0.1 sec increments until the maximum time value is reached
    for (double t = 0; t < this.model.getTime(); t += 0.1)
    {
      screen.moveHorizontal(t);
      screen.moveVertical(t);
      this.update();
      
      System.out.println(t);
    }
  }
  
  /* Updates the animation and text fields after calculations */
  public void update()
  {
    if (blank)
    {
      this.velocity1.setText("");
      this.velocity2.setText("");
      this.displacementX.setText("");
      this.displacementY.setText("");
      this.time.setText("");
      this.angle1.setText("");
      this.angle2.setText("");
      blank = false;
    }
    
    else
    {
      this.velocity1.setText(Double.toString(this.model.getVelocity1()));
      this.velocity2.setText(Double.toString(this.model.getVelocity2()));
      this.displacementX.setText(Double.toString(this.model.getDisplacementX()));
      this.displacementY.setText(Double.toString(this.model.getDisplacementY()));
      this.time.setText(Double.toString(this.model.getTime()));
      this.angle1.setText(Double.toString(this.model.getAngle1()));
      this.angle2.setText(Double.toString(this.model.getAngle2()));
    }
  }
  
  /** Shows an error message if user inputs something invalid */
  public static void errorMessage(int errorCode)
  {
    if (errorCode == 1)
      errorPane.showMessageDialog(error, "Error: Too many values given.");

    else if (errorCode == 2)
      errorPane.showMessageDialog(error, "Error: Horizontal displacement cannot be negative.");
    
    else if (errorCode == 3)
      errorPane.showMessageDialog(error, "Error: Initial angle must be between 0 and 90.");
    
    else if (errorCode == 4)
      errorPane.showMessageDialog(error, "Error: Time has to be positive.");
    
    else if (errorCode == 5)
      errorPane.showMessageDialog(error, "Error: Initial velocity has to be positive.");
    
    else if (errorCode == 6)
      errorPane.showMessageDialog(error, "Error: Impact velocity has to be less than or equal to initial velocity.");
    
    else if (errorCode == 7)
      errorPane.showMessageDialog(error, "Error: Vertical displacement must be less than or equal to zero, since initial vertical velocity is negative.");
    
    else if (errorCode == 8)
      errorPane.showMessageDialog(error, "Error: Vertical displacement must be greater than or equal to zero, since impact vertical velocity is zero.");
    
    else if (errorCode == 9)
      errorPane.showMessageDialog(error, "Error: Insufficient/invalid information.");
  }
}
