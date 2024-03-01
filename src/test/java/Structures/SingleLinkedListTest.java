package Structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static Structures.SingleLinkedList.*;
public class SingleLinkedListTest {
    @Test
    public void testSingleLinkedList() { assertInstanceOf(SingleLinkedList.class, new SingleLinkedList<String>());}
}
