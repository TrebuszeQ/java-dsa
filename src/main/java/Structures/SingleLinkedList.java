package Structures;

import java.util.Iterator;
import java.util.function.Consumer;

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

    private T getMiddleNodeItem(int position) {
        T curr_item = tail.item;
        for(int i = 0; i < position && position <= n; i++) { curr_item = iterator().next(); }
        return curr_item;
    }

    private int validatePosition(int position) {
        return (position >= n && position > 0) ? n :
                (position <= n && position < 0) ? 0 : position;
    }

    private Node<T> traverseList(int position) {
        Node<T> current = null;

        if(position - n < n - n / 2) { for(int i = n; i > position; i--) { current = tail.next; } }

        else { for(int i = n; i < position; i++) { current = head.next; } }

        return current;
    }

    private Node<T> getMiddleNode(int position) {
        return n == 0 ? null :
                (n == 1 || validatePosition(position) == 1) ? tail : traverseList(position);
    }

    public void pushTail(T item) {
        if (n == 0) {
          tail = new Node<>();
          tail.item = item;
          head = tail;
        }

        else if(n == 1) {
            head = tail;
            tail = new Node<>();
            tail.item = item;
            tail.next = head;
        }

        else {
            Node<T> oldTail = tail;
            tail = new Node<T>();
            tail.item = item;
            tail.next = oldTail;
        }
        n++;
    }

    public void pushHead(T item) {
        if(n >= 1) {
            head.next = new Node<>();
            head = head.next;
            head.item = item;
            n++;
        }

        else { pushTail(item); }
    }

    public void pushMiddle(T item, int position) {
        if(n == 1 || n == 0) { pushTail(item); }
        else if (position == n) { pushHead(item); }
        else {
            Node<T> mid = getMiddleNode(position - 1);
            Node<T> chain = mid.next;

            mid.next = new Node<>();
            mid.next.item = item;
            mid.next.next = chain;
            n++;
        }
    }

    public T popTail() {
        T item = n >= 1 ? tail.item : null;

        tail = n == 1 ? null :
                n == 2 ? head : tail.next;

        head = n == 1 ? null :
                n == 2 ? tail : head ;

        n = n > 1 ? n - 1 : 0;
        return item;
    }

    public T popHead() {
        T item;
        if (n == 0) { return null; }

        else if(n == 1) { return popTail(); }

        else if(n == 2) {
            head = tail;
            item = tail.item;
        }

        else {
            item = head.item;
            head = getMiddleNode(n - 1);
            head.next = null;
        }
        n--;

        return item;
    }

    // here
    public T popMiddle(int position) {
        T item  = null;
        if(n > 2 && position != n) {
            Node<T> previous = getMiddleNode(position - 1);
            item = previous.next.item;
            previous.next = previous.next.next;

        }
        else if (n > 2 && position == 1) {

        }

        else if(n == 2 && position != n) { popTail(); }
        else if(n == 2 && position == n ) { popHead(); }
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
