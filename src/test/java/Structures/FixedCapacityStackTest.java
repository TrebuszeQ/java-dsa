package Structures;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {
    void TestPush() {
        FixedCapacityStack<Boolean> arr = new FixedCapacityStack<Boolean>(4);
        for (int i = 0; i < 4; i++) {
            arr.push(true);
        }
        FixedCapacityStack<Boolean> stack2 = new FixedCapacityStack<Boolean>(4);
        assertEquals(arr, stack2);
        return;
    }
}