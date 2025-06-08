# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses)

## Description

<!-- description:start -->

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is **valid**.

An input string is valid if:

- Open brackets must be closed by the **same type** of brackets.
- Open brackets must be closed in the **correct order**.
- Every close bracket has a corresponding open bracket of the same type.

<!-- description:end -->

---

## Examples

### Example 1:
<pre>
Input: s = "()"
Output: true
</pre>

---

### Example 2:
<pre>
Input: s = "()[]{}"
Output: true
</pre>

---

### Example 3:
<pre>
Input: s = "(]"
Output: false
</pre>

---

### Example 4:
<pre>
Input: s = "([])"
Output: true
</pre>

---

## Constraints

- 1 <= s.length <= 10⁴
- `s` consists of parentheses only `'()[]{}'`.

---

## Solutions

### Approach: Use a Stack to Match Parentheses

1. Traverse the string `s` character by character.
2. Push every opening bracket `'('`, `'{'`, `'['` onto the stack.
3. For every closing bracket, check if the top of the stack is the matching opening bracket:
   - If yes, pop the opening bracket from the stack.
   - Otherwise, the string is invalid.
4. After processing all characters, if the stack is empty, the string is valid; otherwise, it is invalid.

---

## Time and Space Complexity

- **Time Complexity:** O(n), where n is the length of the string.
- **Space Complexity:** O(n), for the stack usage in the worst case.

---

## Java Code

```java
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else if (!st.isEmpty() && 
                      ((ch == '}' && st.peek() == '{') || 
                       (ch == ']' && st.peek() == '[') || 
                       (ch == ')' && st.peek() == '('))) {
                st.pop();
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
