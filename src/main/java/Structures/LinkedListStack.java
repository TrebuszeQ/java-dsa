package Structures;

public class LinkedListStack<T> implements Iterable<T> {
    private Node first;
    private int n;


    private class Node<T> {
        <T> item;
        Node next;
    }
    public LinkedListStack<T>(int cap) {
        first = null;
        n = 0;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return n; }
    
}
