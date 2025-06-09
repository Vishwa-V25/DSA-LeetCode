# 739. Daily Temperatures

## 📝 Problem Description

Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i-th` day to get a warmer temperature.  
If there is no future day for which this is possible, keep `answer[i] == 0`.

---

## 📥 Examples

### Example 1

**Input:**  
`temperatures = [73,74,75,71,69,72,76,73]`  
**Output:**  
`[1,1,4,2,1,1,0,0]`

### Example 2

**Input:**  
`temperatures = [30,40,50,60]`  
**Output:**  
`[1,1,1,0]`

### Example 3

**Input:**  
`temperatures = [30,60,90]`  
**Output:**  
`[1,1,0]`

---

## ✅ Constraints

- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

---

## 💡 Approach

- Use a **monotonic decreasing stack** to track indices of previous temperatures.
- For each day, while the current temperature is greater than the temperature at the top index of the stack:
  - Pop from the stack.
  - Update `answer[popIndex] = currentIndex - popIndex`
- Push the current index onto the stack.

---

## 💻 Java Solution

```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int prevIndex = st.pop();
                result[prevIndex] = i - prevIndex;
            }
            st.push(i);
        }

        return result;
    }
}
