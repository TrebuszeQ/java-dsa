package Structures;

public class ResizingStack<T> {

    private T[] arr = null;

    private int n = 0;

    public ResizingStack(int cap) { arr = (T[]) new Object[cap]; }

    public boolean isEmpty() { return n == 0; }

    public boolean isFull() { return n == arr.length; }

    public int size() { return n; }

    private T[] getResizedArr(int max) {
        T[] temp = (T[]) new Object[max];
        if (n >= 0) System.arraycopy(arr, 0, temp, 0, n);
        return temp;
    }

    public void push(T item) {
        if(n == 0) {
            arr[0] = item;
            n++;
        }

        else if (n == arr.length) {
            arr = getResizedArr(2 * arr.length);
            arr[n++] = item;
        }

        else { arr[n++] = item; }
    }

    public T pop() {
        if(n == 0) { return null; }
        else if (n > 0 && n == arr.length/4) {
            T item = arr[--n];
            arr = getResizedArr(arr.length/2);
            return item;
        }
        return arr[--n];
    }
}
