/**
 * @author Tan Zong Zhi, Shaun (Group 16A)
 * @version CS2030S AY21/22 Semester 2
 */
class Array<T extends Comparable<T>> {
  private T[] array;

  public Array(int size) {
    // The only way we can put an object into array is through
    // the method set() and we only put object of type T inside.
    // So it is safe to cast `Object[]` to `T[]`.
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[size];
    this.array = array;
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int index) {
    return this.array[index];
  }

  public T min() {
    T minimum = null;
    for (T element : array) {
      minimum = minimum == null || element.compareTo(minimum) < 0
        ? element
        : minimum;
    }
    return minimum;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
