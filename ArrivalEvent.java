/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class ArrivalEvent extends ShopEvent {
  public ArrivalEvent(Queue entranceQueue, Counter[] counters, Customer customer) {
    super(customer.getArrivalTime(), entranceQueue, counters, customer);
  }

  private Counter getAvailableCounter() {
    for (Counter counter : counters) {
      if (counter.isAvailable()) {
        return counter;
      }
    }
    return null;
  }

  @Override
  public Event[] simulate() {
    if (entranceQueue.isEmpty()) {
      Counter counter = getAvailableCounter();

      if (counter != null) {
        return new Event[] {
          new ServiceBeginEvent(getTime(), entranceQueue, counters, customer, counter)
        };
      }
    } else if (entranceQueue.isFull()) {
      return new Event[] {
        new DepartureEvent(getTime(), entranceQueue, counters, customer)
      };
    }

    return new Event[] {
      new JoinQueueEvent(getTime(), entranceQueue, counters, customer)
    };
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s arrived %s", customer, entranceQueue);
  }
}

