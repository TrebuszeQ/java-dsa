package Structures;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {
    private final FixedCapacityStack<Boolean> stack = new FixedCapacityStack<>(1);

    @Test
    @Order(1)
    public void TestPush() {
        stack.push(true);
        assertNotNull(stack);
    }

    @Test
    @Order(2)
    public void TestPopandEmpty() {
        Boolean pop = stack.pop();
        assertNull(pop);
        assertTrue(stack.isEmpty());
    }

}