/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class DepartureEvent extends Event {
  private final Shop shop;
  private final Customer customer;

  public DepartureEvent(double time, Shop shop, Customer customer) {
    super(time);
    this.shop = shop;
    this.customer = customer;
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
