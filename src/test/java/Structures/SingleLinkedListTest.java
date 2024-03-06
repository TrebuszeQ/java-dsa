package Structures;

import org.junit.jupiter.api.Test;

import static Structures.SingleLinkedList.*;
import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {
    private SingleLinkedList<String> list = new SingleLinkedList<>();;
    @Test
    public void testSingleLinkedList() { assertInstanceOf(SingleLinkedList.class, this.list); }

    @Test
    public void testIsEmpty() { assertTrue(list.isEmpty()); }

    @Test
    public void testSize() { assertEquals(0, list.size()); }

    @Test
    public void testPushPopTailWhenEmpty() {
        String item = "paczek";
        assertEquals(0, list.size());
        list.pushTail(item);
        assertEquals(1, list.size());
        assertEquals(list.popTail(), item);
        list.pushTail(item);
    }
    @Test
    public void testPushPopTailWhenNotEmpty() {
        list.pushTail("paczek");
        String item = "gofr";
        assertEquals(1, list.size());
        list.pushTail(item);
        assertEquals(2, list.size());
        assertEquals(item, list.popTail());
    }

    @Test
    public void testPushAndPopHeadWhenEmpty() {
        assertEquals(0, list.size());
        list.pushHead("paczek");
        assertEquals(1, list.size());
        assertEquals(list.popHead(), "paczek");
        assertEquals(0, list.size());

    }

    @Test
    public void testPushAndPopHeadWhenNotEmpty() {
        assertEquals(0, list.size());
        list.pushHead("paczek");
        assertEquals(1, list.size());
        list.pushHead("gofr");
        assertEquals(2, list.size());
        list.pushHead("bulka");
        assertEquals(3, list.size());
        assertEquals(list.popHead(), "bulka");
        assertEquals(2, list.size());
    }

    @Test
    public void testPushHeadPopMiddleWhenNotEmpty() {
        assertEquals(0, list.size());
        list.pushHead("paczek");
        assertEquals(1, list.size());
        list.pushHead("gofr");
        assertEquals(2, list.size());
        list.pushHead("bulka");
        assertEquals(3, list.size());
        assertEquals("gofr", list.popMiddle(2));
    }

    @Test
    public void testPushHeadPopMiddleWhenEmpty() {
        assertNull(list.popMiddle(2));
    }

}
