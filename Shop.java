/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
public class Shop {
  private final Counter[] counters;
  private final Queue<Customer> entranceQueue;

  public Shop(int numOfCounters, int entranceQueueLength) {
    this.counters = new Counter[numOfCounters];
    this.entranceQueue = new Queue<Customer>(entranceQueueLength);

    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter(i);
    }
  }

  public Counter getAvailableCounter() {
    for (Counter counter : counters) {
      if (counter.isAvailable()) {
        return counter;
      }
    }
    return null;
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
