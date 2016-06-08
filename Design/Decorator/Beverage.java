
public class Beverage {
  
  String description = " Unknown Beverage";
  
  Size size; 
  
  public String getDescription() {
      return description;
  }
  
  public Size getSize() {
    return size;
  }
  
  public void setSize(Size s) {
    this.size = s;
  }
  
  public abstract double cost();
}
