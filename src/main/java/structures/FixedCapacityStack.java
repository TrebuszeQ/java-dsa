package structures;

// N = 0
// Top = a[N-1]
public class FixedCapacityStack<T> {
    private T[] arr;
    private int n = 0;

    public FixedCapacityStack(int cap) {
        arr = (T[]) new Object[cap];
    }

    void push(T item) {
        if (n == 0) {
            arr[0] = item;
            n++;
        }
        else arr[n++] = item;
    }

    T pop() {
        if (n == 0) return null;
        else return arr[--n];
    }

    boolean isEmpty() { return n == 0; }

    boolean isFull() { return n == arr.length; }

    int size() { return arr.length; }
}
