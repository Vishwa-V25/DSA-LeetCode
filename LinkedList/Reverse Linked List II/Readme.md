# [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii)

## Description

<!-- description:start -->

Given the head of a singly linked list and two integers `left` and `right` where `left <= right`, reverse the nodes of the list from position `left` to position `right`, and return the modified list.

<!-- description:end -->

---

## Examples

### Example 1:

<pre>
<strong>Input:</strong> head = [1,2,3,4,5], left = 2, right = 4  
<strong>Output:</strong> [1,4,3,2,5]
</pre>

---

### Example 2:

<pre>
<strong>Input:</strong> head = [5], left = 1, right = 1  
<strong>Output:</strong> [5]
</pre>

---

## Constraints

- The number of nodes in the list is `n`.
- `1 <= n <= 500`
- `-500 <= Node.val <= 500`
- `1 <= left <= right <= n`

---

## Solutions

### Approach: In-Place Reversal using Pointers

1. Use a dummy node before `head` to handle edge cases easily.
2. Move a `prev` pointer to the node just before the `left` position.
3. Reverse the sublist from `left` to `right` by re-linking nodes iteratively.
4. Return `dummy.next` which now points to the new head.

This avoids using extra space and performs the reversal in one pass (excluding the initial traversal to position).

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Dummy node simplifies edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before 'left'
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Reverse the sublist from left to right
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}
