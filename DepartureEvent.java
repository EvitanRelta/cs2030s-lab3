/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class DepartureEvent extends ShopEvent {
  public DepartureEvent(double time, Queue entranceQueue, Counter[] counters, Customer customer) {
    super(time, entranceQueue, counters, customer);
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s departed", customer);
  }
}
