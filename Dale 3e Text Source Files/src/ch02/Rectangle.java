// this class added to stop the compilation error in UseFigs.java
// it is NOT CORRECT 

package ch02;

public class Rectangle implements FigureGeometry
{
  protected float radius;
  protected int scale;
      
  public Rectangle(float length, float width)
  {
    this.radius = radius;
  }    
       
  public float perimeter()
  // Returns perimeter of this figure.
  {
    return(2 * PI * radius);
  }
   
  public float area()
  // Returns area of this figure.
  {
    return(PI * radius * radius);
  }
      
  public void setScale(int scale)
  // Scale of this figure is set to "scale".
  {
    this.scale = scale;
  }
            
  public float weight()
  // Precondition: Scale of this figure has been set.
  //
  // Returns weight of this figure. Weight = area X scale.
  {
    return(this.area() * scale);
  }
}
