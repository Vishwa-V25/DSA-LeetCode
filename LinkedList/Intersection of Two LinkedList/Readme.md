# [160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)

## Description

<!-- description:start -->

Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

**Note:** The linked lists must retain their original structure after the function returns.

<!-- description:end -->

---

## Examples

### Example 1:
<img src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png" width="500"/>
<pre>
<strong>Input:</strong> intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
<strong>Output:</strong> Intersected at '8'
</pre>

---

### Example 2:
<img src="https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png" width="500"/>
<pre>
<strong>Input:</strong> intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>Output:</strong> Intersected at '2'
</pre>

---

### Example 3:
<img src="https://assets.leetcode.com/uploads/2021/03/05/160_example_3.png" width="400"/>
<pre>
<strong>Input:</strong> intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>Output:</strong> No intersection
</pre>

---

## Constraints

- The number of nodes of `listA` is in the range **[1, 3 × 10⁴]**
- The number of nodes of `listB` is in the range **[1, 3 × 10⁴]**
- **1 ≤ Node.val ≤ 10⁵**
- **0 ≤ skipA < m**
- **0 ≤ skipB < n**
- `intersectVal` is `0` if the lists do not intersect.
- `intersectVal == listA[skipA] == listB[skipB]` if the lists intersect.

---

## Solutions

### Approach: Two Pointers

1. Initialize two pointers `pA` and `pB` at the heads of `listA` and `listB`.
2. Traverse both lists. When `pA` reaches the end of list A, redirect it to head of B.
3. When `pB` reaches the end of list B, redirect it to head of A.
4. If the lists intersect, `pA` and `pB` will eventually meet at the intersection node.
5. If they do not intersect, both will become `null` at the end.

This ensures both pointers traverse equal distance.

---

## Time and Space Complexity

- **Time Complexity:** O(m + n)
- **Space Complexity:** O(1)

---

## Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}

