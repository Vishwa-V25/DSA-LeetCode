# 678. Valid Parenthesis String

## 📝 Problem Description

Given a string `s` containing only three types of characters: `'('`, `')'`, and `'*'`, return `true` if the string is **valid**.

A string is considered valid if it meets the following criteria:

### Validity Rules:
1. Every `'('` must have a corresponding `')'`.
2. Every `')'` must have a corresponding `'('`.
3. `'('` must appear before its corresponding `')'`.
4. `'*'` can be treated as:
   - An `'('`
   - A `')'`
   - An empty string `""`

---

## 📥 Examples

### Example 1
**Input:**  
`s = "()"`  
**Output:**  
`true`

---

### Example 2
**Input:**  
`s = "(*)"`  
**Output:**  
`true`

---

### Example 3
**Input:**  
`s = "(*))"`  
**Output:**  
`true`

---

## ✅ Constraints

- `1 <= s.length <= 100`
- `s[i]` is one of `'('`, `')'`, or `'*'`

---

## 💡 Approach

To validate the string, use two stacks:

- One stack to track indices of `'('`
- Another stack to track indices of `'*'`

### Algorithm:
1. Traverse the string character by character.
2. If `'('`, push its index onto the `left` stack.
3. If `'*'`, push its index onto the `star` stack.
4. If `')'`, try to match it with a `'('`. If not available, try to use a `'*'`.
5. After traversal, match any unmatched `'('` with a `'*'` that comes **after** it.

If any `'('` remains unmatched after this, the string is invalid.

---

## 💻 Java Solution

```java
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') {
                star.push(i);
            } else if (ch == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
