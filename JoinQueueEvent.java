/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class JoinQueueEvent extends ShopEvent {
  public JoinQueueEvent(double time, Queue entranceQueue, Counter[] counters, Customer customer) {
    super(time, entranceQueue, counters, customer);
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
    entranceQueue.enq(customer);

    return new Event[] {};
  }

  @Override
  public String toString() {
    return super.toString()
      + String.format(": %s joined queue %s", customer, entranceQueue);
  }
}
