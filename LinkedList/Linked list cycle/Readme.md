# [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle)

## Description

<!-- description:start -->

Given `head`, the head of a linked list, determine if the linked list has a **cycle** in it.

A cycle exists if a node can be reached again by continuously following the `next` pointer. Internally, `pos` denotes the index of the node that the tail's `next` pointer connects to.  
**Note:** `pos` is not passed as a parameter.

Return `true` if there is a cycle in the linked list. Otherwise, return `false`.

<!-- description:end -->

---

## Examples

### Example 1:
<img alt="example1" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" style="width: 400px;" />
<pre>
<strong>Input:</strong> head = [3,2,0,-4], pos = 1
<strong>Output:</strong> true
<strong>Explanation:</strong> The tail connects to the node at index 1.
</pre>

---

### Example 2:
<img alt="example2" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png" style="width: 300px;" />
<pre>
<strong>Input:</strong> head = [1,2], pos = 0
<strong>Output:</strong> true
<strong>Explanation:</strong> The tail connects to the node at index 0.
</pre>

---

### Example 3:
<img alt="example3" src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png" style="width: 180px;" />
<pre>
<strong>Input:</strong> head = [1], pos = -1
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no cycle in the linked list.
</pre>

---

## Constraints

- The number of nodes in the list is in the range **[0, 10⁴]**.
- **−10⁵ ≤ Node.val ≤ 10⁵**
- `pos` is `-1` or a valid index in the linked list.

---

## Solutions

### Approach: Floyd’s Cycle Detection Algorithm (Tortoise and Hare)

We use two pointers:

1. `slow` moves one step at a time.
2. `fast` moves two steps at a time.

If there is a cycle, the two pointers will eventually meet.  
If there is no cycle, the `fast` pointer will reach the end (`null`).

This approach is efficient and doesn't use extra space.

---

## Time and Space Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

---

## Java

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}

