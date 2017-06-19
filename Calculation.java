//Standard Test Calculations

//Given
//dX = 96
//dY = -82
//angle1 = 0
//
//t = 4.1
//v1 = 23

//Given
//angle1 = 42
//v1 = 12
//dY = -9.5
//
//t = 2.4
//dX = 22
//v2 = 18
//angle2 = -60

/** Calculation class
  * Model that performs calculations
  * @author Nicolas Chatziargiriou, William San, Tu Tran
  * @since 6/16/17 */ 
public class Calculation extends Object
{
  private GUI view;               //The view for the simulation
  
  private double time;            //The time of the projectile motion (seconds)
  private double time2;           //The second time of the projectile motion (quadratic) (seconds)
  private double velocity1;       //The inital speed of the projectile (meters/second)
  private double velocity2;       //The final speed of the projectile (meters/second)
  private double displacementX;   //The horizontal displacement of the projectile (meters)
  private double displacementY;   //The vertical displacement of the projectile (meters)
  private double angle1;          //The inital velocity's angle above or below the horizontal (above +, below -) (degrees)
  private double angle2;          //The final velocity's angle above or below the horizontal (above +, below -) (degrees)'
  private double velocity1Y;      //The y-component of projectile's initial speed (meters/second)
  private double velocity1X;      //The x-component of projectile's initial speed (meters/second)
  private double velocity2Y;      //The y-component of projectile's final speed (meters/second)
  private double velocity2X;      //The x-component of projectile's final speed (meters/second)
  
  private boolean missing;        //Determines if there are still any values to calculate
  private boolean timeB;          //Determines if time is present
  private boolean velocity1B;     //Determines if initial velocity is present
  private boolean velocity1YB;    //Determines if initial velocity is present
  private boolean velocity2B;     //Determines if final velocity is present
  private boolean velocity2YB;    //Determines if final velocity is present
  private boolean velocityXB;     //Determines if any velocity is present (v1X = v2X)
  private boolean displacementXB; //Determines if displacement in the x direction is present
  private boolean displacementYB; //Determines if displacement in the y direction is present

/** Default Constructor */
public Calculation()
{
  super();
   
  this.missing = true;
  this.timeB = false;
  this.velocity1B = false;
  this.velocity1YB = false;
  this.velocity2B = false;
  this.velocity2YB = false;
  this.velocityXB = false;
  this.displacementXB = false;
  this.displacementYB = false;
}

/** Sets view for the calculations */
public void setGUI(GUI aView)
{
  this.view = aView;
}


/** Get the time
  * @return Time of projectile motion */
public double getTime()
{
  return (Math.round(this.time*100)/100.0);
}
/** Get the time2
  * @return Time2 of projectile motion */
public double getTime2()
{
  return (Math.round(this.time2*100)/100.0);
}

/** Get the initial velocity
  * @return The inital speed of the projectile (meters/seconds) */
public double getVelocity1()
{
  return (Math.round(this.velocity1*100)/100.0);
}

/** Get the initial velocity's x component
  * @return The inital speed of the projectile (meters/seconds) */
public double getVelocity1X()
{
  return (Math.round(this.velocity1X*100)/100.0);
}

/** Get the initial velocity's y component
  * @return The inital speed of the projectile (meters/seconds) */
public double getVelocity1Y()
{
  return (Math.round(this.velocity1Y*100)/100.0);
}

/** Get the final velocity
  * @return The final speed of the projectile (meters/seconds) */
public double getVelocity2()
{
  return (Math.round(this.velocity2*100)/100.0);
}

/** Get the final velocity's y component
  * @return The final speed of the projectile (meters/seconds) */
public double getVelocity2Y()
{
  return (Math.round(this.velocity2Y*100)/100.0);
}

/** Get the final velocity's x component
  * @return The final speed of the projectile (meters/seconds) */
public double getVelocity2X()
{
  return (Math.round(this.velocity2X*100)/100.0);
}

/** Get the displacement in the X direction
  * @return The horizontal displacement of the projectile (meters) */
public double getDisplacementX()
{
  return (Math.round(this.displacementX*100)/100.0);
}

/** Get the displacement in the Y direction
  * @return The vertical displacement of the projectile (meters) */
public double getDisplacementY()
{
  return (Math.round(this.displacementY*100)/100.0);
}

/** Get the inital velocity's angle
  * @return The inital velocity's angle above or below the horizontal (above +, below -) (degrees) */
public double getAngle1()
{
  return (Math.round(this.angle1*10)/10.0);
}

/** Get the final velocity's angle
  * @return The final velocity's angle above or below the horizontal (above +, below -) (degrees) */
public double getAngle2()
{
  return (Math.round(this.angle2*10)/10.0);
}


/** Sets the time to the argument provided 
  * @aTime The time */
public void setTime(double aTime)
{
  this.time = aTime;
  timeB = true;
}

/** Sets the initial velocity to the argument provided 
  * @aVelocity1 The initial velocity */
public void setVelocity1(double aVelocity1)
{
  this.velocity1 = aVelocity1;
  velocity1B = true;
}

/** Sets the final velocity to the argument provided 
  * @aVelocity1 The final velocity */
public void setVelocity2(double aVelocity2)
{
  this.velocity2 = aVelocity2;
  velocity2B = true;
}

/** Sets the displacement x to the argument provided 
  * @aDisplacementX The displacement in the x direction */
public void setDisplacementX(double aDisplacementX)
{
  this.displacementX = aDisplacementX;
  displacementXB = true;
}

/** Sets the displacement y to the argument provided 
  * @aDisplacementY The displacement in the y direction */
public void setDisplacementY(double aDisplacementY)
{
  this.displacementY = aDisplacementY;
  displacementYB = true;
}

/** Sets the initial angle to the argument provided 
  * @anAngle1 The initial angle */
public void setAngle1(double anAngle1)
{
  this.angle1 = anAngle1;
  velocity1Y = velocity1*Math.sin(Math.toRadians(angle1));
  velocity1X = velocity1*Math.cos(Math.toRadians(angle1));
  velocity2X = velocity1X;
  
  velocity1YB = true;
  velocityXB = true;
}

/** Sets the final angle to the argument provided 
  * @anAngle2 The final angle */
public void setAngle2(double anAngle2)
{
  this.angle2 = anAngle2;
  velocity2Y = velocity2*Math.sin(Math.toRadians(angle2));
  velocity2X = velocity2*Math.cos(Math.toRadians(angle2));
  velocity1X = velocity2X;
  
  velocity2YB = true;
  velocityXB = true;
}


/** Determines which operation and calculation to perform based on given variables */
public void calculate()
{ 
  //Solve for time
  if (timeB == false)
  {
    calcTime();
  }
  
  //Solve for remaining info
  while (missing)
  {
    if (velocityXB && displacementXB && velocity1YB && velocity2YB && velocity1B && velocity2B && displacementYB)
    {
      missing = false;
    }
    else
    {
      missing = true;
    }
    
    if (velocityXB == false)
    {
      calcVX();
    }
    else if (velocity1YB == false)
    {
      calcV1Y();
    }
    else if (velocity2YB == false)
    {
      calcV2Y();
    }
    else if (velocity1B == false && velocity1YB && velocityXB)
    {
      calcV1();
    }
    else if (velocity2B == false && velocity2YB && velocityXB)
    {
      calcV2();
    }
    else if (displacementXB == false)
    {
      calcDX();
    }
    else if (displacementYB == false)
    {
      calcDY();
    }
  }
  
  updateView();
}


/** Calculates the time */
public void calcTime()
{
  //Calculate time from y direction
  if (velocity1YB && velocity2YB)
  {
    time = (velocity2Y-velocity1Y)/-9.8;
  }
  
  else if (velocity1YB && displacementYB)
  {
    if (velocity1Y == 0)
    {
      time = Math.sqrt((2*displacementY)/-9.8);
    }
    else if (displacementY <= 0)
    {
      time = (-velocity1Y+Math.sqrt((Math.pow(velocity1Y,2))-(4*(-9.8/2)*(-displacementY))))/-9.8;
      //Don't use negative time
      if (time < 0)
      {
        time = (-velocity1Y-Math.sqrt((Math.pow(velocity1Y,2))-(4*(-9.8/2)*(-displacementY))))/-9.8;
      }
    }
    //Quadratic equation (2 solutions)
    else
    {
      time = (-velocity1Y+Math.sqrt((Math.pow(velocity1Y,2))-(4*(-9.8/2)*(-displacementY))))/-9.8;
      time2 = (-velocity1Y-Math.sqrt((Math.pow(velocity1Y,2))-(4*(-9.8/2)*(-displacementY))))/-9.8;
    }
  }
  
  else if (velocity2YB && displacementYB)
  {
    //Projectile lands at apex
    if (velocity2Y == 0)
    {
      time = Math.sqrt((2*displacementY)/9.8);
    }
    else
    {
      time = (-velocity2Y+Math.sqrt((Math.pow(velocity2Y,2))-(4*(9.8/2)*displacementY)))/9.8;
      //Don't use negative time
      if (time < 0)
      {
        time = (-velocity2Y+Math.sqrt((Math.pow(velocity2Y,2))-(4*(9.8/2)*displacementY)))/9.8;
      }
    }
  }
  
  //Calculate time from x direction
  else if (velocityXB && displacementXB)
  {
    time = displacementX/velocity1X;
  }
  
  timeB = true;
}

/** Calculates the initial and final velocity's x component */
public void calcVX()
{
  if (displacementXB) //Check unnecessary
  {
    velocity1X = displacementX/time;
    velocity2X = velocity1X;
  }
  velocityXB = true;
}

/** Calculates the initial velocity's y component */
public void calcV1Y()
{
  if (displacementYB)
  {
    velocity1Y = (displacementY - (-9.8/2)*(Math.pow(time,2)))/time;
  }
  else if (velocity2YB)
  {
    velocity1Y = velocity2Y/(-9.8*time);
  }
  velocity1YB = true;
}

/** Calculates the final velocity's y component */
public void calcV2Y()
{
  if (displacementYB)
  {
    velocity2Y = (displacementY + (-9.8/2)*(Math.pow(time,2)))/time;
  }
  else if (velocity1YB)
  {
    velocity2Y = velocity1Y + (-9.8*time);
  }
  velocity2YB = true;
}

/** Calculates the initial velocity */
public void calcV1()
{
  velocity1 = Math.sqrt(Math.pow(velocity1X,2)+Math.pow(velocity1Y,2));
  angle1 = Math.toDegrees(Math.atan(velocity1Y/velocity1X));
  velocity1B = true;
}

/** Calculates the final velocity */
public void calcV2()
{
  velocity2 = Math.sqrt(Math.pow(velocity2X,2)+Math.pow(velocity2Y,2));
  angle2 = Math.toDegrees(Math.atan(velocity2Y/velocity2X));
  velocity2B = true;
}

/** Calculates the displacement x */
public void calcDX()
{
  if (velocityXB) //Unnecessary
  {
    displacementX = velocity1X*time;
  }
  displacementXB = true;
}

/** Calculates the displacement y */
public void calcDY()
{
  if (velocity1YB)
  {
    displacementY = velocity1*time + (-9.8/2)*(Math.pow(time,2));
  }
  else if (velocity2YB)
  {
    displacementY = velocity2Y*time - (-9.8/2)*(Math.pow(time,2));
  }
  displacementYB = true;
}


/** Updates the view in the GUI */
public void updateView()
{
  view.update();
}

/** Resets all values for new calculations */
public void reset()
{
  GUI.blank = true;
  
  time = 0;
  time2 = 0;
  velocity1 = 0;
  velocity1Y = 0;
  velocity1X = 0;
  velocity2 = 0;
  velocity2Y = 0;
  velocity2X = 0;
  
  timeB = false;
  missing = true;
  velocity1B = false;
  velocity1YB = false;
  velocity2B = false;
  velocity2YB = false;
  velocityXB = false;
  displacementXB = false;
  displacementYB = false;
  
  updateView();
}
}
