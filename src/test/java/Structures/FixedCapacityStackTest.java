package Structures;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {
    FixedCapacityStack<Boolean> stack = new FixedCapacityStack<>(0);
//    public FixedCapacityStackTest() {
//
//   }

    // here
    public static void TestPush(FixedCapacityStack<Boolean> stack) {
        stack.push(true);
        assertNotNull(stack);
    }

    public static void TestPop() {

    }
    public static void main(String[] args) {

    }
}