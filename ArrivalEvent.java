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
      Counter counter = shop.getCounterToJoin();

      return counter == null
        ? new Event[] {
            new JoinEntranceQueueEvent(getTime(), shop, customer)
        }
        : counter.isAvailable()
        ? new Event[] {
            new ServiceBeginEvent(getTime(), shop, customer, counter)
        }
        : new Event[] {
            new JoinCounterQueueEvent(getTime(), shop, customer, counter)
        };
    } else if (shop.hasFullEntranceQueue()) {
      return new Event[] {
          new DepartureEvent(getTime(), shop, customer)
      };
    }

    return new Event[] {
        new JoinEntranceQueueEvent(getTime(), shop, customer)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(
          ": %s arrived %s",
          customer,
          shop.getEntranceQueueString()
      );
  }
}

