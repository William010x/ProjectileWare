/**Calculation class
  * Performs calculations
  * @since 5/19/2017
  * @author  Nicolas Chatziargiriou
  */
////////////////////////////////////////

// Calculation LookUp Table:

//  Aav = (V2-V1)ΔD
//  V2 = V1+(A)ΔT
//  ΔD = ((V1+V2)/2)ΔT
//  ΔD = V2(ΔT)-1/2(A)ΔT^2
//  V2^2 = V1^2 + 2(A)ΔD
//  ΔD = V1(ΔT)+1/2(A)ΔT^2

////////////////////////////////////////



public class Calculation extends Object
{
private  GUI view;

private double time;
private double velocity1;
private double velocity2;
private double displacementX;
private double displacementY;
private double angle1;
private double angle2;

//private boolean timeB;
//private boolean velocity1B;
//private boolean velocity2B;
//private boolean displacementXB;
//private boolean displacementYB;
//private boolean angle1B;
//private boolean angle2B;

public Calculation()
{
  super();
}

public void setGUI(GUI theView)
{
  this.view=theView;
}

////////////////////////////////////
public double getTime()
{
  return this.time;
}

public double getVelocity1()
{
  return this.velocity1;
}

public double getVelocity2()
{
  return this.velocity2;
}

public double getDisplacementX()
{
  return this.displacementX;
}

public double getDisplacementY()
{
  return this.displacementY;
}

public double getAngle1()
{
  return this.angle1;
}

public double getAngle2()
{
  return this.angle2;
}

///////////////////////////////////
public void calculate()
{
}

///////////////////////////////////
public void setTime(double aTime)
{
  this.time = aTime;
}

public void setVelocity1(double aVelocity)
{
  this.velocity1 = aVelocity;
}

public void setVelocity2(double aVelocity)
{
  this.velocity2 = aVelocity;
}

public void setDisplacementX(double aDisplacementX)
{
  this.displacementX = aDisplacementX;
}

public void setDisplacementY(double aDisplacementY)
{
  this.displacementY = aDisplacementY;
}

public void setAngle1(double anAngle)
{
  this.angle1 = anAngle;
}

public void setAngle2(double anAngle)
{
  this.angle2 = anAngle;
}

///////////////////////////////////
public void updateView()
{
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



}
