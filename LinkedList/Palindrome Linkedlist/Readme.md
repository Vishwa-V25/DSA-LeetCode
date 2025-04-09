# [234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list)

## Description

<!-- description:start -->

Given the `head` of a singly linked list, return `true` if it is a **palindrome**, or `false` otherwise.

<!-- description:end -->

---

## Examples

### Example 1:
<img src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" width="400"/>
<pre>
<strong>Input:</strong> head = [1,2,2,1]
<strong>Output:</strong> true
</pre>

---

### Example 2:
<img src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" width="300"/>
<pre>
<strong>Input:</strong> head = [1,2]
<strong>Output:</strong> false
</pre>

---

## Constraints

- The number of nodes in the list is in the range **[1, 10⁵]**.
- **0 ≤ Node.val ≤ 9**

---

## Solutions

### Approach: Store in List and Use Two-Pointer Check

1. Traverse the linked list and store values in an ArrayList.
2. Use two pointers (`left`, `right`) to check if the list is a palindrome.
3. If all values from both ends match, return `true`.

This approach uses additional space but is simple and easy to implement.

---

## Time and Space Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

---

## Java

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
       List<Integer> list = new ArrayList<>();
       while (head != null) {
           list.add(head.val);
           head = head.next;
       }

       int left = 0;
       int right = list.size() - 1;

       while (left < right && list.get(left) == list.get(right)) {
           left++;
           right--;
       }

       return left >= right;
    }
}
