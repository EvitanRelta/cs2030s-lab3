/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ServiceBeginEvent extends Event {
  private final Shop shop;
  private final Customer customer;
  private final Counter counter;

  public ServiceBeginEvent(double time, Shop shop, Customer customer, 
      Counter counter) {
    super(time);
    this.shop = shop;
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public Event[] simulate() {
    double endTime = getTime() + customer.getServiceTime();
    counter.serve(customer);

    return new Event[] {
      new ServiceEndEvent(endTime, shop, customer, counter)
    };
  }
  
  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s service begin (by %s)", customer, counter);
  }
}
