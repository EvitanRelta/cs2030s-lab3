/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ServiceBeginEvent extends ShopEvent {
  private Counter counter;

  public ServiceBeginEvent(double time, Queue entranceQueue, Counter[] counters, Customer customer, 
      Counter counter) {
    super(time, entranceQueue, counters, customer);
    this.counter = counter;
    counter.serve(customer);
  }

  @Override
  public Event[] simulate() {
    double endTime = getTime() + customer.getServiceTime();
    return new Event[] {
      new ServiceEndEvent(endTime, entranceQueue, counters, customer, counter)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s service begin (by %s)", customer, counter);
  }
}
