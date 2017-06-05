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
  JTextField angle1;          //display/entry for initial angle
  JTextField angle2;          //display/entry for impact angle
  JTextField time;            //display/entry for time
  JTextField displacementX;   //display/entry for final horizontal displacement
  JTextField displacementY;   //display/entry for final vertical displacement
  
  JButton start;              //the start button
  JButton calculate;          //the calculate button
  JButton reset;              //the reset button
  Animation screen;           //the animation of the problem
  JPanel input;               //panel containing input fields
  JPanel buttonPanel;         //panel containing the buttons
  
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
    
    screen = new Animation();
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
    input.add(velocity2);
    input.add(angle1);
    input.add(angle2);
    input.add(time);
    input.add(displacementX);
    input.add(displacementY);
    
    buttonPanel.add(start);
    buttonPanel.add(reset);
    buttonPanel.add(calculate);
    
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
    this.screen.start();
    this.update();
  }
  
  /* Updates the animation and text fields after calculations */
  public void update()
  {
    this.velocity1.setText(this.model.getVelocity1());
    this.velocity2.setText(this.model.getVelocity2());
    this.displacementX.setText(this.model.getDisplacementX());
    this.displacementY.setText(this.model.getDisplacementY());
    this.time.setText(this.model.getTime());
    this.angle.setText(this.model.getAngle());
  }
  
  /* Resets the values of the textfields */
  public void reset()
  {
    this.velocity1.setText("");
    this.velocity2.setText("");
    this.angle.setText("");
    this.time.setText("");
    this.displacementX.setText("");
    this.displacementY.setText("");
  }
}
