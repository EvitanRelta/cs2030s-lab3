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
    DepartureEvent departureEvent = new DepartureEvent(getTime(), shop,
        customer);
    
    if (counter.hasQueueLengthZero()) {
      // Take customers directly from entrance queue.
      Customer nextEntranceCustomer = shop.getNextEntranceCustomer();

      return nextEntranceCustomer == null
        ? new Event[] { departureEvent }
        : new Event[] {
            departureEvent,
            new ServiceBeginEvent(getTime(), shop, nextEntranceCustomer, counter)
        };
    }

    Customer nextCustomer = counter.getNextCustomer();
    Customer nextEntranceCustomer = shop.getNextEntranceCustomer();

    // If nextCustomer == null, then nextEntranceCustomer must be null too.
    if (nextCustomer == null) {
      return new Event[] { departureEvent };
    }

    return nextEntranceCustomer == null
        ? new Event[] {
            departureEvent,
            new ServiceBeginEvent(getTime(), shop, nextCustomer, counter)
        }
        : new Event[] {
            departureEvent,
            new ServiceBeginEvent(getTime(), shop, nextCustomer, counter),
            new JoinCounterQueueEvent(getTime(), shop, nextEntranceCustomer, 
                counter)
        };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s service done (by %s)", customer, counter);
  }
}
