# [844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare)

## Description

<!-- description:start -->

Given two strings `s` and `t`, return `true` if they are equal when both are typed into empty text editors.  
`'#'` means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

<!-- description:end -->

---

## Examples

### Example 1:
<pre>
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
</pre>

---

### Example 2:
<pre>
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
</pre>

---

### Example 3:
<pre>
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
</pre>

---

## Constraints

- 1 <= s.length, t.length <= 200
- `s` and `t` only contain lowercase letters and `'#'` characters.

---

## Solutions

### Approach: Use Two Stacks to Simulate the Backspace Effect

1. Iterate through string `s`, for each character:
   - If it is `'#'` and the stack is not empty, pop the top character.
   - Otherwise, if it is a letter, push it onto the stack.
2. Repeat the same process for string `t`.
3. Compare the resulting stacks:
   - If their sizes differ, return `false`.
   - Otherwise, pop from both stacks and compare characters.
   - If any mismatch, return `false`.
4. If all characters match, return `true`.

---

## Time and Space Complexity

- **Time Complexity:** O(n + m), where `n` and `m` are the lengths of strings `s` and `t`.
- **Space Complexity:** O(n + m) for the stacks used to simulate the strings.

---

## Java Code

```java
import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '#' && !st1.isEmpty()) {
                st1.pop();
            } else if (ch != '#') {
                st1.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#' && !st2.isEmpty()) {
                st2.pop();
            } else if (ch != '#') {
                st2.push(ch);
            }
        }

        if (st1.size() != st2.size()) {
            return false;
        }

        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }

        return true;
    }
}
