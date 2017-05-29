////////////////////////////////////////

// Calculation LookUp Table:

//  Aav = (V2-V1)ΔD
//  V2 = V1+(A)ΔT
//  ΔD = ((V1+V2)/2)ΔT
//  ΔD = V2(ΔT)-1/2(A)ΔT^2
//  V2^2 = V1^2 + 2(A)ΔD
//  ΔD = V1(ΔT)+1/2(A)ΔT^2

////////////////////////////////////////

/**
  * Calculation class
  * Model that performs calculations
  * @since 5/19/2017
  * @author Nicolas Chatziargiriou
  */
public class Calculation extends Object
{
  private GUI view;              //The view for the simulation

  private double time;           //The time of the projectile motion (s)
  private double velocity1;      //The inital speed of the projectile (m/s)
  private double velocity2;      //The final speed of the projectile (m/s)
  private double displacementX;  //The horizontal displacement of the projectile (m)
  private double displacementY;  //The vertical displacement of the projectile (m)
  private double angle1;         //The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  private double angle2;         //The final velocity's angle above or below the horizontal (above +, below -) (degrees)

//private boolean timeB;
//private boolean velocity1B;
//private boolean velocity2B;
//private boolean displacementXB;
//private boolean displacementYB;
//private boolean angle1B;
//private boolean angle2B;

/**
  * Default Constructor
  */
public Calculation()
{
  super();
}

/**
  * Sets view for the program
  * @param currentGUI The view used to display the program
  */ 
public void setGUI(GUI currentView)
{
  this.view = currentView;
}

/** 
  * Get the time
  * @return Time of projectile motion
  */
public double getTime()
{
  return (this.time);
}


/** 
  * Get the initial velocity
  * @return The inital speed of the projectile (m/s)
  */
public double getVelocity1()
{
  return (this.velocity1);
}

/** 
  * Get the final velocity
  * @return The final speed of the projectile (m/s)
  */
public double getVelocity2()
{
  return (this.velocity2);
}

/** 
  * Get the displacement in the X direction
  * @return The horizontal displacement of the projectile (m)
  */
public double getDisplacementX()
{
  return (this.displacementX);
}

/** 
  * Get the displacement in the Y direction
  * @return The vertical displacement of the projectile (m)
  */
public double getDisplacementY()
{
  return (this.displacementY);
}

/** 
  * Get the inital velocity's angle
  * @return The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  */
public double getAngle1()
{
  return (this.angle1);
}

/** 
  * Get the final velocity's angle
  * @return The final velocity's angle above or below the horizontal (above +, below -) (degrees)
  */
public double getAngle2()
{
  return (this.angle2);
}

/** 
  * Sets the time
  * @param aTime Time of projectile motion
  */ 
public void setTime(double aTime)
{
  this.time = aTime;
}

/** 
  * Set the initial velocity
  * @return The inital speed of the projectile (m/s)
  */
public void setVelocity1(double aVelocity)
{
  this.velocity1 = aVelocity;
}

/** 
  * Set the final velocity
  * @return The final speed of the projectile (m/s)
  */
public void setVelocity2(double aVelocity)
{
  this.velocity2 = aVelocity;
}

/** 
  * Set the displacement in the X direction
  * @return The horizontal displacement of the projectile (m)
  */
public void setDisplacementX(double aDisplacementX)
{
  this.displacementX = aDisplacementX;
}

/** 
  * Set the displacement in the Y direction
  * @return The vertical displacement of the projectile (m)
  */
public void setDisplacementY(double aDisplacementY)
{
  this.displacementY = aDisplacementY;
}

/** 
  * Set the initial velocity's angle
  * @return The initial velocity's angle above or below the horizontal (above +, below -) (degrees)
  */
public void setAngle1(double anAngle)
{
  this.angle1 = anAngle;
}

/** 
  * Set the final velocity's angle
  * @return The final velocity's angle above or below the horizontal (above +, below -) (degrees)
  */
public void setAngle2(double anAngle)
{
  this.angle2 = anAngle;
}

/**
  * Determines which operation and calculation to perform based on given variables
  */
public void calculate()
{
}

///////////////////////////////////
public void calcV1X()
{
}

///////////////////////////////////
public void calcV2X()
{
}

///////////////////////////////////
public void calcV1Y()
{
}

///////////////////////////////////
public void calcV2Y()
{
}

///////////////////////////////////
public void calcTime()
{
}

///////////////////////////////////
public void calcXD()
{
}

///////////////////////////////////
public void calcDY()
{
}

/** 
  * Updates the view in the GUI
  */
public void updateView()
{
  view.update();
}
