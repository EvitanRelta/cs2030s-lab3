/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 */
public class Counter {
  private final int id;
  private Customer customer;

  public Counter(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "S" + id;
  }
}
