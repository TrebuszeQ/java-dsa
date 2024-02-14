package Structures;

// N = 0
// Top = a[N-1]
public class FixedCapacityStack<T> {
    private T[] arr;
    private int n;

    public FixedCapacityStack(int cap) { arr = (T[]) new Object[cap]; }

    void push(T item) {
        if (n == arr.length) resize(2 * arr.length);
        arr[n] = item;
    }

    T pop() { return arr[n - 1]; }

    boolean isEmpty() { return n == 0; }

    boolean isFull() { return n == arr.length; }

    int size() { return arr.length; }

    private void resize(int max) {
        T[]temp = (T[]) new Object[max];

        System.arraycopy(arr, 0, temp, 0, max);
        arr = temp;
    }
}
