# [86. Partition List](https://leetcode.com/problems/partition-list)

## Description

<!-- description:start -->

Given the head of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal to** `x`.

You **must preserve the original relative order** of the nodes in each of the two partitions.

<!-- description:end -->

---

## Examples

### Example 1:

<pre>
<strong>Input:</strong> head = [1,4,3,2,5,2], x = 3  
<strong>Output:</strong> [1,2,2,4,3,5]
</pre>

---

### Example 2:

<pre>
<strong>Input:</strong> head = [2,1], x = 2  
<strong>Output:</strong> [1,2]
</pre>

---

## Constraints

- The number of nodes in the list is in the range [0, 200].
- `-100 <= Node.val <= 100`
- `-200 <= x <= 200`

---

## Solutions

### Approach: Two Dummy Lists (Before and After)

- Use two dummy nodes:
  - One for nodes with values less than `x`.
  - One for nodes with values greater than or equal to `x`.
- Traverse the original list and distribute nodes into these two lists.
- Join the two lists together at the end.

---

## Time and Space Complexity

- **Time Complexity:** O(n) — each node is visited once.
- **Space Complexity:** O(1) — no extra memory used beyond pointers.

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0); // For nodes < x
        ListNode dummy2 = new ListNode(0); // For nodes >= x
        ListNode before = dummy1;
        ListNode after = dummy2;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Connect the two partitions
        before.next = dummy2.next;
        after.next = null;

        return dummy1.next;
    }
}
