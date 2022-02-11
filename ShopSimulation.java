import java.util.Scanner;

/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ShopSimulation extends Simulation {
  public final Customer[] customers;
  public final Counter[] counters;
  public final Queue entranceQueue;
  private final Event[] initEvents;

  public ShopSimulation(Scanner sc) {
    customers = new Customer[sc.nextInt()];
    counters = new Counter[sc.nextInt()];
    entranceQueue = new Queue(sc.nextInt());

    for (int i = 0; i < customers.length; i++) {
      customers[i] = new Customer(i, sc.nextDouble(), sc.nextDouble());
    }

    for (int i = 0; i < counters.length; i++) {
      counters[i] = new Counter(i);
    }

    initEvents = new Event[customers.length];
    for (int i = 0; i < customers.length; i++) {
      initEvents[i] = new ArrivalEvent(entranceQueue, counters, customers[i]);
    }
  }

  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }
}
