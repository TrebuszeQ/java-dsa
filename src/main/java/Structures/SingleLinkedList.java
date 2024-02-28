package Structures;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    int n;
    public SingleLinkedList() {
        head = null;
        tail = null;
        n = 0;
    }

    private static class Node<T> {
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

    private T getMiddleNodeItem(int position) {
        T curr_item = tail.item;
        for(int i = 0; i < position && position <= n; i++) { curr_item = iterator().next(); }
        return curr_item;
    }

    private Node<T> getMiddleNode(int position) {
        Node<T> current = tail;
        for(int i = 0; i < position && position <= n; i++) { current = tail.next; }
        return current;
    }
    public void pushHead(T item) {
        head.next = new Node<>();
        head.next.item = item;
        head = head.next;
        n++;
    }

    public void pushMiddle(T item, int position) {
        if(position == n) {
            // here
            return pushHead(item);
        }
        Node<T> mid = getMiddleNode(position - 1);
        Node<T> chain = mid.next;

        mid.next = new Node<>();
        mid.next.item = item;

        mid.next.next = chain;
    }

    public T popTail() {
        T item = tail.item;
        tail = null;
        n--;
        return item;
    }

    public T popHead() {
        Node<T> mid = getMiddleNode(n - 1);
        T item = head.item;
        mid.next = null;
        head = null;
        n--;
        return item;
    }

    @Override
    public Iterator<T> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<T> {
        private Node<T> current = tail;
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
