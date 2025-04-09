# [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list)

## Description

<!-- description:start -->

Given the `head` of a singly linked list, return the **middle node** of the linked list.

If there are two middle nodes, return the **second** middle node.

<!-- description:end -->

---

## Examples

### Example 1:
<img alt="example1" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 400px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

---

### Example 2:
<img alt="example2" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 400px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

---

## Constraints

- The number of nodes in the list is in the range **[1, 100]**.
- **1 ≤ Node.val ≤ 100**

---

## Solutions

### Approach: Fast and Slow Pointer

We use two pointers:

- `slow` moves one step at a time.
- `fast` moves two steps at a time.

When `fast` reaches the end of the list, `slow` will be at the middle.

This ensures that if there are two middle nodes, we return the second one as required.

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
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

