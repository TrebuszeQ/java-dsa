package Structures;

import java.util.Iterator;

public class ResizingStack<T> {

    private T[] arr;
    private int n;

    public ResizingStack(int cap) {
        arr = (T[]) new Object[cap];
        n = 0;
    }

    public boolean isEmpty() { return n == 0; }

    public boolean isFull() { return n == arr.length; }

    public int size() { return n; }

    private T[] getResizedArr(int max) {
        T[] temp = (T[]) new Object[max];
        System.arraycopy(arr, 0, temp, 0, n);
        return temp;
    }

    public void push(T item) {
        if (n == arr.length && n == 0) {
            arr = getResizedArr(2);
            arr[n] = arr[0] = item;
        }

        else if (n == arr.length) {
            arr = getResizedArr(2 * arr.length);
            arr[n] = arr[n++] = item;
        }

        else { arr[n] = item; }
        n++;
    }

    public T pop() {
        if (n == 0) {
            return null;
        }

        else if (n > 0 && n == arr.length / 4) {
            T item = arr[--n];
            arr = getResizedArr(arr.length / 2);
            return item;
        }
        return arr[--n];
    }

    public Iterator<T> iterator() { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n;
        public boolean hasNext() { return i > 0; }
        public T next() { return arr[--i]; }
        public void remove() {}

    }
}


