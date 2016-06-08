
public class Beverage {
  
  String description = " Unknown Beverage";
  
  Size size; 
  
  public String getDescription() {
      return description;
  }
  
  public abstract double cost();
}
