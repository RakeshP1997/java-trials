package easy;

import java.util.Stack;

/** Problem statement: 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */
public class QueueUsingTwoStacks {
    class MyQueue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        private void rotateStacks(Stack s1, Stack s2) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        public int pop() {
            rotateStacks(stack1,stack2);
            int op = stack2.pop();
            rotateStacks(stack2,stack1);
            return op;
        }

        public int peek() {
            rotateStacks(stack1,stack2);
            int op = stack2.peek();
            rotateStacks(stack2,stack1);
            return op;
        }

        public boolean empty() {
            return stack1.empty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
