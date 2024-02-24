package Structures;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ResizingStackTest {
    final private ResizingStack<String> stack;
    public ResizingStackTest() { stack = new ResizingStack<>(0);}

    @Test
    public void testIsEmpty() { assertTrue(stack.isEmpty()); }

    @Test
    public void testIsFull() { assertTrue(stack.isFull()); }

    @Test
    public void testSize() { assertEquals(0, stack.size()); }

    @Test
    public void testGetResizedArr() {
        Method getResizedArr;
        boolean[] result;
        try {
            getResizedArr = ResizingStack.class.getMethod("getResizedArr", int.class);
            getResizedArr.setAccessible(true);
            result = (boolean[]) getResizedArr.invoke(stack, 4);
        }

        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) { System.out.printf("%s", e); return; }
        assertEquals(4, result.length);

    }

    @Test
    public void testPushAndPop() {
        stack.push("lol");
        stack.push("lol2");
        assertEquals(2, stack.size());
        assertEquals("lol2", stack.pop());
        assertEquals("lol", stack.pop());
    }
}