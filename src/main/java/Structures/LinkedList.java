package Structures;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    Node<T> tail;
    int n;
    public LinkedList() {
        tail = null;
        n = 0;
    }

    protected static class Node<T> {
        T item;
        Node<T> next;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }
    public void pushTail(T item) {
        Node<T> oldTail = tail;
        tail = new Node<T>();
        tail.item = item;
        tail.next = oldTail;
        n++;
    }

    public T popTail() {
        T item = tail.item;
        tail = null;
        n--;
        return item;
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = (Node<T>) tail;
        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public void remove() {}
        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

}
