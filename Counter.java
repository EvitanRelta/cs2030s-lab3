/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
public class Counter implements Comparable<Counter> {
  private final int id;
  private Customer customer;
  private Queue<Customer> queue;

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

  public void joinQueue(Customer customer) {
    queue.enq(customer);
  }

  public Customer getNextCustomer() {
    return queue.deq();
  }

  @Override
  public String toString() {
    return "S" + id;
  }

  @Override
  public int compareTo(Counter counter) {
    return this.queue.length() < counter.queue.length()
        || (this.isAvailable() && !counter.isAvailable())
        || this.id < counter.id
      ? -1
      : 1;
  }
}
