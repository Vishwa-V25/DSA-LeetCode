# [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists)

## Description

You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one **sorted list**. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

---

## Examples

### Example 1:
<img alt="example1" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 400px;" />
<pre>
<strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

---

### Example 2:
<pre>
<strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

---

### Example 3:
<pre>
<strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

---

## Constraints

- The number of nodes in both lists is in the range **[0, 50]**.
- **−100 ≤ Node.val ≤ 100**
- Both `list1` and `list2` are sorted in **non-decreasing** order.

---

## Approach

### Iterative Merge Using Dummy Node

1. Create a dummy node to act as the start of the merged list.
2. Use a `current` pointer to build the merged list by comparing `list1` and `list2` values.
3. Attach the smaller node to `current.next`, and move the pointer forward.
4. After the loop, attach any remaining part of either list to `current.next`.

This avoids the need for complex pointer handling or recursion.

---

## Time and Space Complexity

- **Time Complexity:** O(n + m), where `n` and `m` are the lengths of the input lists.
- **Space Complexity:** O(1) — in-place merging with no extra data structures.

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
}
