/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ServiceEndEvent extends Event {
  private final Shop shop;
  private final Customer customer;
  private final Counter counter;

  public ServiceEndEvent(double time, Shop shop, Customer customer,
      Counter counter) {
    super(time);
    this.shop = shop;
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public Event[] simulate() {
    counter.endService();
    Customer nextCustomer = counter.getNextCustomer();
    nextCustomer = nextCustomer != null
        ? nextCustomer
        : shop.getNextEntranceCustomer();
    DepartureEvent departureEvent = new DepartureEvent(getTime(), shop,
        customer);

    if (nextCustomer == null) {
      return new Event[] { departureEvent };
    }
    
    return new Event[] {
        departureEvent,
        new ServiceBeginEvent(getTime(), shop, nextCustomer, counter)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s service done (by %s)", customer, counter);
  }
}
