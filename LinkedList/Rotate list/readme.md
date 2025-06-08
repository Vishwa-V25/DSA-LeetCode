# [61. Rotate List](https://leetcode.com/problems/rotate-list)

## Description

<!-- description:start -->

Given the head of a linked list, rotate the list to the right by `k` places.

<!-- description:end -->

---

## Examples

### Example 1:
<pre>
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
</pre>

---

### Example 2:
<pre>
Input: head = [0,1,2], k = 4
Output: [2,0,1]
</pre>

---

## Constraints

- The number of nodes in the list is in the range **[0, 500]**.
- **-100 <= Node.val <= 100**
- **0 <= k <= 2 * 10^9**

---

## Solutions

### Approach: Rotate by linking tail to head and adjusting pointers

1. First, find the length of the linked list.
2. Modulo `k` by the length to handle rotations larger than the list length.
3. Connect the last node to the head to form a circular linked list.
4. Find the new tail after `(length - k)` steps.
5. Break the circle by setting the new tail’s `next` to `null`.
6. Return the new head (the node after the new tail).

This approach avoids rotating the list by one node at a time and is efficient.

---

## Time and Space Complexity

- **Time Complexity:** O(n), where n is the number of nodes in the linked list.
- **Space Complexity:** O(1)

---

## Java Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Compute the length and get the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make it a circular list
        tail.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        k = k % length;
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // Break the circle

        return newHead;
    }
}

