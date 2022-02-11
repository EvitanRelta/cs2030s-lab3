/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ArrivalEvent extends Event {
  private final Shop shop;
  private final Customer customer;

  public ArrivalEvent(Shop shop, Customer customer) {
    super(customer.getArrivalTime());
    this.shop = shop;
    this.customer = customer;
  }

  @Override
  public Event[] simulate() {
    if (shop.hasEmptyEntranceQueue()) {
      Counter counter = shop.getAvailableCounter();

      if (counter != null) {
        return new Event[] {
          new ServiceBeginEvent(getTime(), shop, customer, counter)
        };
      }
    } else if (shop.hasFullEntranceQueue()) {
      return new Event[] {
        new DepartureEvent(getTime(), shop, customer)
      };
    }

    return new Event[] {
      new JoinQueueEvent(getTime(), shop, customer)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s arrived %s", customer, shop.getEntranceQueueString());
  }
}

