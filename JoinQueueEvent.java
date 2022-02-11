/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class JoinQueueEvent extends Event {
  private final Shop shop;
  private final Customer customer;

  public JoinQueueEvent(double time, Shop shop, Customer customer) {
    super(time);
    this.shop = shop;
    this.customer = customer;
  }

  @Override
  public Event[] simulate() {
    shop.joinEntranceQueue(customer);

    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s joined queue %s", customer, shop.getEntranceQueueString());
  }
}
