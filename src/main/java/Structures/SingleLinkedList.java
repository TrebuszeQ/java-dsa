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
            while(n != position - 1) { current = head.next; }
        return current;
    }

    private Node<T> getMiddleNode(int position) {
        position = validatePosition(position);
        Node<T> current = null;

        current = n == 0 ? null :
                (n == 1 || position == 1) ? tail :
                        (position / 2 > position / n) ? head :

        if(position / 2 > position / n) { for(int i = n; i < position; i++) { current = head.next; }}

        else if(position / 2 < position / n) { for(int i = n; i > position; i--) { current = tail.next; }}

        return current;
    }

    public void pushTail(T item) {
        if(n == 1) {
            head = tail;
            tail = new Node<T>();
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
        if(head != null) {
            head.next = new Node<>();
            head.next.item = item;
            head = head.next;
            n++;
        }

        else { pushTail(item); }
    }

    public void pushMiddle(T item, int position) {
        if (position == n) {
            pushHead(item);
        }

        else if (position == 0) {
            pushTail(item);
        }

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
        T item = n == 0 ? null :
                    n == 1 ? tail.item : head.item;

        if(n == 1) {
            head = null;
            tail = null;
            n = 0;
        }
        else if(n == 2) {
            head = tail;
        }
        else {
            head = getMiddleNode(n - 1);
            head.next = null;
        }

        n--;
        return item;
    }

    public T popMiddle(int position) {
        Node<T> previous = getMiddleNode(position - 1);
        T mid_item = previous.next.item;
        previous.next = previous.next.next;

        return mid_item;
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
