# [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii)

## Description

<!-- description:start -->

Given the head of a **sorted linked list**, delete all nodes that have duplicate numbers, leaving only **distinct numbers** from the original list. Return the modified sorted list.

<!-- description:end -->

---

## Examples

### Example 1:

<pre>
<strong>Input:</strong> head = [1,2,3,3,4,4,5]  
<strong>Output:</strong> [1,2,5]
</pre>

---

### Example 2:

<pre>
<strong>Input:</strong> head = [1,1,1,2,3]  
<strong>Output:</strong> [2,3]
</pre>

---

## Constraints

- The number of nodes in the list is in the range [0, 300].
- `-100 <= Node.val <= 100`
- The list is guaranteed to be **sorted in ascending order**.

---

## Solutions

### Approach: Two Pointers with Dummy Node

- Use a dummy node to handle edge cases (like deleting the head).
- Use a `prev` pointer to connect the last non-duplicate node to the correct next node.
- Traverse the list:
  - If a node has duplicates (i.e., `head.val == head.next.val`), skip all nodes with that value.
  - If the value is unique, move `prev` forward.

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
