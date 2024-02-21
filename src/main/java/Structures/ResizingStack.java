package Structures;

import java.sql.Array;

public class ResizingStack<T> {

    private T[] arr = null
    private int n = 0;
    public ResizingStack(int cap) {
        arr = (T[]) new Object[cap];
    }
}
