# [232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks)

## Description

<!-- description:start -->

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

- `void push(int x)` — Pushes element `x` to the back of the queue.
- `int pop()` — Removes the element from the front of the queue and returns it.
- `int peek()` — Returns the element at the front of the queue.
- `boolean empty()` — Returns `true` if the queue is empty, `false` otherwise.

**Notes:**

- You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
- Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

<!-- description:end -->

---

## Examples

### Example 1:
<pre>
Input:
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]

Output:
[null, null, null, 1, 1, false]

Explanation:
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek();  // returns 1
myQueue.pop();   // returns 1, queue is now [2]
myQueue.empty(); // returns false
</pre>

---

## Constraints

- 1 <= x <= 9
- At most 100 calls will be made to `push`, `pop`, `peek`, and `empty`.
- All the calls to `pop` and `peek` are valid.

---

## Solutions

### Approach: Use Two Stacks to Simulate a Queue

- Maintain two stacks, `st1` and `st2`.
- `push(x)` — Push element `x` onto `st1`. Update `front` if `st1` was empty.
- `pop()` — Move all elements from `st1` to `st2`, pop from `st2`, update `front` if `st2` is not empty, then move elements back to `st1`.
- `peek()` — Return the `front` element.
- `empty()` — Check if `st1` is empty.

This ensures that the oldest element pushed is always accessible for `pop` and `peek`.

---

## Time and Space Complexity

- **Time Complexity:**  
  - `push` — O(1)  
  - `pop` — O(n) (due to stack transfer)  
  - `peek` — O(1)  
  - `empty` — O(1)

- **Space Complexity:** O(n), for storing elements in stacks.

---

## Java Code

```java
import java.util.Stack;

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    int front;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        if (st1.isEmpty()) {
            front = x;
        }
        st1.push(x);
    }

    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int last = st2.pop();
        if (!st2.isEmpty()) {
            front = st2.peek();
        }
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return last;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return st1.isEmpty();
    }
}
