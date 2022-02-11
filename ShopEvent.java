/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
abstract class ShopEvent extends Event {
  protected final Queue entranceQueue;
  protected final Counter[] counters;
  protected final Customer customer;

  public ShopEvent(double time, Queue entranceQueue, Counter[] counters, Customer customer) {
    super(time);
    this.entranceQueue = entranceQueue;
    this.counters = counters;
    this.customer = customer;
  }
}
