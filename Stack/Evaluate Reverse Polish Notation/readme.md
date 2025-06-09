# 150. Evaluate Reverse Polish Notation

## Problem Description

You are given an array of strings `tokens` that represents an arithmetic expression in Reverse Polish Notation (RPN).

**Evaluate the expression** and return the result as an integer.

### Notes:
- The valid operators are `+`, `-`, `*`, and `/`.
- Each operand may be an integer or another expression.
- Division between two integers should truncate toward zero.
- The input is guaranteed to be a valid RPN expression.
- Intermediate and final results will fit within a 32-bit signed integer.

---

## Examples

### Example 1
**Input:**  
`tokens = ["2", "1", "+", "3", "*"]`  
**Output:**  
`9`  
**Explanation:**  
((2 + 1) * 3) = 9

### Example 2
**Input:**  
`tokens = ["4", "13", "5", "/", "+"]`  
**Output:**  
`6`  
**Explanation:**  
(4 + (13 / 5)) = 6

### Example 3
**Input:**  
`tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]`  
**Output:**  
`22`  
**Explanation:**  
((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22

---

## Constraints

- `1 <= tokens.length <= 10^4`
- `tokens[i]` is either an operator `("+", "-", "*", "/")` or an integer in the range `[-200, 200]`

---

## Java Solution

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (String ch : tokens) {
            if (ch.equals("+")) {
                st.push(st.pop() + st.pop());
            } else if (ch.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if (ch.equals("*")) {
                st.push(st.pop() * st.pop());
            } else if (ch.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else {
                st.push(Integer.parseInt(ch));
            }
        }
        
        return st.peek();
    }
}
