package structures;

import java.util.Iterator;

public class DoubleLinkedList<T> extends SingleLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    int n;
    public DoubleLinkedList() {
        super();
        head = null;
        tail = null;
        n = 0;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> previous;
    }

    public boolean isEmpty() { return n == 0; }
    public int size() { return n; }

    public void pushTail(T item) { super.pushTail(item); }

    public void pushHead(T item) { super.pushHead(item); }

    private Node<T> traverseList(int position) {
        Node<T> current = null;

        if(position - n < n - n / 2) { return n }
    }

    private Node<T> getMiddleNode(int position) {
        return n == 0 ? null :
                (n == 1 || super.validatePosition(position) == 1) ?
    }

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
