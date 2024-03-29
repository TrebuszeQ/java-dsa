package Structures;

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
    public void pushHead(T item) {
        head.next = new Node<T>();
        head.next.item = item;
        head = head.next;
        n++;
    }

    public T getMiddleNodeItem(int position) { return getMiddleNode(position).item; }

    private Node<T> getMiddleNode(int position) {
        Node<T> current = tail;
        for(int i = 0; i < position && position <= n; i++) { current = tail.next; }
        return current;
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
