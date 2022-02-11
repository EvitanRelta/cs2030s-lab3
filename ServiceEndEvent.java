/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ServiceEndEvent extends ShopEvent {
  private Counter counter;

  public ServiceEndEvent(double time, Queue entranceQueue, Counter[] counters, Customer customer,
      Counter counter) {
    super(time, entranceQueue, counters, customer);
    this.counter = counter;
  }

  @Override
  public Event[] simulate() {
    counter.endService();
    Customer nextCustomer = (Customer) entranceQueue.deq();

    if (nextCustomer == null) {
      return new Event[] {
          new DepartureEvent(getTime(), entranceQueue, counters, customer)
      };
    }
    
    return new Event[] {
        new DepartureEvent(getTime(), entranceQueue, counters, customer),
        new ServiceBeginEvent(getTime(), entranceQueue, counters, nextCustomer, counter)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s service done (by %s)", customer, counter);
  }
}
