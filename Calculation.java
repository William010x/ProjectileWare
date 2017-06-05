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

  private double time;           //The time of the projectile motion (seconds)
  private double velocity1;      //The inital speed of the projectile (meters/second)
  private double velocity2;      //The final speed of the projectile (meters/second)
  private double displacementX;  //The horizontal displacement of the projectile (meters)
  private double displacementY;  //The vertical displacement of the projectile (meters)
  private double angle1;         //The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  private double angle2;         //The final velocity's angle above or below the horizontal (above +, below -) (degrees)'
  private double velocity1Y;     //The y-component of projectile's initial speed (meters/second)
  private double velocity1X;     //The x-component of projectile's initial speed (meters/second)
  private double velocity2Y;     //The y-component of projectile's final speed (meters/second)
  private double velocity2X;     //The x-component of projectile's final speed (meters/second)
  

private boolean xB;
private boolean yB;
private boolean timeB;
private boolean velocity1YB;
private boolean velocity2YB;
private boolean velocityXB;
private boolean displacementXB;
private boolean displacementYB;
//private boolean angle1B;
//private boolean angle2B;

public Calculation()
{
  super();
  this.time = -404;
  this.velocity1 = -404;
  this.displacementX = -404;
  this.displacementY = -404;
  this.angle1 = -404;
  this.angle2 = -404;
}

public void setGUI(GUI aView)
{
  this.view = aView;
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
  * @return The inital speed of the projectile (meters/seconds)
  */
public double getVelocity1()
{
  return (this.velocity1);
}

/** 
  * Get the final velocity
  * @return The final speed of the projectile (meters/seconds)
  */
public double getVelocity2()
{
  return (this.velocity2);
}

/** 
  * Get the displacement in the X direction
  * @return The horizontal displacement of the projectile (meters)
  */
public double getDisplacementX()
{
  return (this.displacementX);
}

/** 
  * Get the displacement in the Y direction
  * @return The vertical displacement of the projectile (meters)
  */
public double getDisplacementY()
{
  return this.displacementY;
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
  * Determines which operation and calculation to perform based on given variables
  */
public void calculate()
{
  //Check if enough info is given in x
  if ((velocityXB && displacementXB) || (velocityXB && timeB) || (displacementXB && timeB)
  {
    xB = true;
  }
  //Check if enough info is given in y
  else if ((velocity1YB && velocity2YB && displacementY) || (velocity2YB && displacementY && timeB))
  {
    yB = true;
  }
  else if (velocity1YB && displacementYB)
  {
    if (velocity1Y == 0)
    {
      time = Math.sqrt(2*displacementX);
    }
    else
    {
      time = (-velocity1Y+Math.sqrt((Math.pow(velocity1Y,2))-(4*(9.8/2)*(-displacementY))))/9.8;
      time2 = (-velocity1Y-Math.sqrt((Math.pow(velocity1Y,2))-(4*(9.8/2)*(-displacementY))))/9.8;
    }
  }
  else if (velocity2YB && displacementYB)
  {
    time = (-velocity1+Math.sqrt((Math.pow(b,2))-(4*a*c)))/(2*a);
  }

  if (timeB == false)
  {
    calcTime();
  }
  else if (
}

///////////////////////////////////

public void setTime(double aTime)
{
  this.time = aTime;
  timeB = true;
}

public void setVelocity1(double aVelocity)
{
  this.velocity1 = aVelocity;
  velocity1B = true;
}

public void setVelocity2(double aVelocity)
{
  this.velocity2 = aVelocity;
  velocity2B = true;
}

public void setDisplacementX(double aDisplacementX)
{
  this.displacementX = aDisplacementX;
  displacementXB = true;
}

public void setDisplacementY(double aDisplacementY)
{
  this.displacementY = aDisplacementY;
  displacementYB = true;
}

public void setAngle1(double anAngle)
{
  this.angle1 = anAngle;
  velocity1Y = velocity1*Math.sin(angle1);
  velocity1X = velocity1*Math.cos(angle1);
  velocity2X = velocity1X;
  
  velocity1YB = true;
  velocityXB = true;
}

public void setAngle2(double anAngle)
{
  this.angle2 = anAngle;
  velocity2Y = velocity2*Math.sin(angle2);
  velocity2X = velocity2*Math.cos(angle2);
  velocity1X = velocity2X;
  
  velocity2YB = true;
  velocityXB = true;
}

///////////////////////////////////
public void calcAng()
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


public void calcTime()
{
  //Check if time can be calculated from x direction
  if (velocityXB && displacementXB)
  {
    time = displacementX/velocity1X;
  }
  //Check if time can be calculated from y direction
  else if (velocity1YB && velocity2YB)
  {
    //Absolute value? -ve acceleration
    time = (velocity2-velocity1)/9.8;
  }
  else if (velocity1YB && displacementYB)
  {
    if (velocity1Y == 0)
    {
      time = Math.sqrt(2*displacementX);
    }
    else
    {
      time = (-velocity1Y+Math.sqrt((Math.pow(velocity1Y,2))-(4*(9.8/2)*(-displacementY))))/9.8;
      time2 = (-velocity1Y-Math.sqrt((Math.pow(velocity1Y,2))-(4*(9.8/2)*(-displacementY))))/9.8;
    }
  }
  else if (velocity2YB && displacementYB)
  {
    time = (-velocity1+Math.sqrt((Math.pow(b,2))-(4*a*c)))/(2*a);
  }
}


public void calcDX()
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

public void reset()
{
}
}
