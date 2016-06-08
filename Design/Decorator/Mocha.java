
public class Mocha extends CondimentDecorator {

  Beverage beverage;
  
  public Mocha(Beverage beverage) {
      this.beverage = beverage;
  }
  
  public String getDescription() {
      return beverage.getDescriton() + ", Mocha";
  }
  
  public double cost() {
    double cost = beverage.cost();
    if(getSize() == Size.Tall) {
      cost += 0.1;
    } else if (getSize() == Size.Grande) {
      cost += 0.15;
    } else if (getSize() == Size.Venti) {
      cost += 0.2;
    }
    return cost;
  }
}
