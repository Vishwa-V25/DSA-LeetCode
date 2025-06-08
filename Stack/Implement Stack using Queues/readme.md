# [225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues)

## Description

<!-- description:start -->

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (`push`, `top`, `pop`, and `empty`).

Implement the `MyStack` class:

- `void push(int x)` — Pushes element `x` to the top of the stack.
- `int pop()` — Removes the element on the top of the stack and returns it.
- `int top()` — Returns the element on the top of the stack.
- `boolean empty()` — Returns `true` if the stack is empty, `false` otherwise.

**Notes:**

- You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
- Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

<!-- description:end -->

---

## Examples

### Example 1:
<pre>
Input:
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]

Output:
[null, null, null, 2, 2, false]

Explanation:
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top();   // returns 2
myStack.pop();   // returns 2
myStack.empty(); // returns false
</pre>

---

## Constraints

- 1 <= x <= 9
- At most 100 calls will be made to `push`, `pop`, `top`, and `empty`.
- All the calls to `pop` and `top` are valid.

---

## Solutions

### Approach: Use Two Queues to Simulate Stack Behavior

- Maintain two queues, `q1` and `q2`.
- For `push(x)`, add element to `q2`, then enqueue all elements of `q1` into `q2`.  
- Swap the names of `q1` and `q2`.
- For `pop()`, dequeue from `q1`.
- For `top()`, peek the front element of `q1`.
- For `empty()`, check if `q1` is empty.

This ensures that the most recently pushed element is always at the front of `q1`, simulating stack behavior.

---

## Time and Space Complexity

- **Time Complexity:**  
  - `push` — O(n), where n is the number of elements in the stack (due to queue transfer).  
  - `pop`, `top`, and `empty` — O(1).

- **Space Complexity:** O(n), for storing elements in queues.

---

## Java Code

```java
import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
