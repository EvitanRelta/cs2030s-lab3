/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class JoinCounterQueueEvent extends Event {
  private final Shop shop;
  private final Customer customer;
  private final Counter counter;

  public JoinCounterQueueEvent(double time, Shop shop, Customer customer, Counter counter) {
    super(time);
    this.shop = shop;
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public Event[] simulate() {
    counter.joinQueue(customer);

    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s joined shop queue %s", customer, shop.getEntranceQueueString());
  }
}

