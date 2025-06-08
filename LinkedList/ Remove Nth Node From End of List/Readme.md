# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list)

## Description

<!-- description:start -->

Given the head of a linked list, remove the `n`th node from the **end of the list** and return its head.

<!-- description:end -->

---

## Examples

### Example 1:

<img alt="example1" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 400px;" />

<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2  
<strong>Output:</strong> [1,2,3,5]
</pre>

---

### Example 2:

<pre>
<strong>Input:</strong> head = [1], n = 1  
<strong>Output:</strong> []
</pre>

---

### Example 3:

<pre>
<strong>Input:</strong> head = [1,2], n = 1  
<strong>Output:</strong> [1]
</pre>

---

## Constraints

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

---

## Solutions

### Approach: Count Nodes First

- First, count the number of nodes.
- Then, calculate the position to remove from the beginning.
- Special case: If the node to remove is the head, return `head.next`.
- Otherwise, iterate to the node before the target and adjust pointers.

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
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c = 0;
        ListNode h = head;

        // Count total nodes
        while (h != null) {
            c++;
            h = h.next;
        }

        // If removing the head
        if (c == n) {
            return head.next;
        }

        // Find the node before the one to remove
        ListNode temp = head;
        int v = c - n;
        for (int i = 0; i < v - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Skip the nth node from end
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }
}
