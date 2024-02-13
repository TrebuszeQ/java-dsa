package Structures;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {
    boolean TestPush() {
        FixedCapacityStack<Boolean> arr = new FixedCapacityStack<Boolean>(4);
        for (int i = 0; i < 4; i++) {
            arr.push(true);
        }

        FixedCapacityStack<Boolean> arr2 = new FixedCapacityStack<Boolean>(4) {
            true, true, true, true
        };

        assertEquals(arr, arr2);
    }
}