import java.util.Scanner;

/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ShopSimulation extends Simulation {
  private final Customer[] customers;
  private final Event[] initEvents;

  public ShopSimulation(Scanner sc) {
    customers = new Customer[sc.nextInt()];
    Shop shop = new Shop(sc.nextInt(), sc.nextInt(), sc.nextInt());
    
    for (int i = 0; i < customers.length; i++) {
      customers[i] = new Customer(i, sc.nextDouble(), sc.nextDouble());
    }
    
    initEvents = new Event[customers.length];
    for (int i = 0; i < customers.length; i++) {
      initEvents[i] = new ArrivalEvent(shop, customers[i]);
    }
  }
  
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
