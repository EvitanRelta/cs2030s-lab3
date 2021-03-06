/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
class Counter implements Comparable<Counter> {
  private final int id;
  private Customer customer;
  private final Queue<Customer> queue;

  public Counter(int id, int queueLength) {
    this.id = id;
    this.queue = new Queue<Customer>(queueLength);
  }
  
  public boolean isAvailable() {
    return this.customer == null;
  }

  public void serve(Customer customer) {
    this.customer = customer;
  }

  public void endService() {
    customer = null;
  }

  public boolean hasFullQueue() {
    return queue.isFull();
  }

  public boolean hasQueueLengthZero() {
    return queue.length() == 0;
  }

  public void joinQueue(Customer customer) {
    queue.enq(customer);
  }

  public Customer getNextCustomer() {
    return queue.deq();
  }

  @Override
  public String toString() {
    return String.format("S%s %s", id, queue);
  }

  @Override
  public int compareTo(Counter counter) {
    if (this.isAvailable() && counter.isAvailable()) {
      return this.id < counter.id
        ? -1
        : 1;
    }
    if (this.isAvailable() && !counter.isAvailable()) {
      return -1;
    }
    if (!this.isAvailable() && counter.isAvailable()) {
      return 1;
    }
    if (this.queue.length() != counter.queue.length()) {
      return this.queue.length() < counter.queue.length()
        ? -1
        : 1;
    }
    return this.id < counter.id
      ? -1
      : 1;
  }
}
