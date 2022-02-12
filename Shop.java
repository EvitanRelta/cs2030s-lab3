/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
public class Shop {
  private final Array<Counter> counters;
  private final Queue<Customer> entranceQueue;

  public Shop(int numOfCounters, int entranceQueueLength,
      int counterQueueLength) {
    this.counters = new Array<Counter>(numOfCounters);
    this.entranceQueue = new Queue<Customer>(entranceQueueLength);

    for (int i = 0; i < numOfCounters; i++) {
      counters.set(i, new Counter(i, counterQueueLength));
    }
  }

  public Counter getCounterToJoin() {
    Counter counter = counters.min();
    return counter.hasFullQueue()
      ? null
      : counter;
  }

  public boolean hasEmptyEntranceQueue() {
    return entranceQueue.isEmpty();
  }

  public boolean hasFullEntranceQueue() {
    return entranceQueue.isFull();
  }

  public String getEntranceQueueString() {
    return entranceQueue.toString();
  }

  public void joinEntranceQueue(Customer customer) {
    entranceQueue.enq(customer);
  }

  public Customer getNextEntranceCustomer() {
    return entranceQueue.deq();
  }
}
