# 71. Simplify Path

## 📝 Problem Description

You are given an **absolute path** for a Unix-style file system, which always begins with a `/`.

Your task is to transform this path into its **simplified canonical path**.

### Canonical Path Rules:
- A single period `.` refers to the current directory.
- A double period `..` moves up one directory (if possible).
- Multiple slashes `//` are treated as a single slash `/`.
- Valid folder names can include multiple periods, like `...` or `....`.
- The result must:
  - Start with a single `/`
  - Not end with a slash `/` (unless it's the root)
  - Not contain `.` or `..`

---

## 📥 Examples

### Example 1
**Input:** `/home/`  
**Output:** `/home`  
**Explanation:** Trailing slash is removed.

---

### Example 2
**Input:** `/home//foo/`  
**Output:** `/home/foo`  
**Explanation:** Multiple slashes are reduced to one.

---

### Example 3
**Input:** `/home/user/Documents/../Pictures`  
**Output:** `/home/user/Pictures`  
**Explanation:** `..` moves up one directory.

---

### Example 4
**Input:** `/../`  
**Output:** `/`  
**Explanation:** Already at root, cannot go higher.

---

### Example 5
**Input:** `/.../a/../b/c/../d/./`  
**Output:** `/.../b/d`  
**Explanation:** Only `.` and `..` are treated specially.

---

## ✅ Constraints

- `1 <= path.length <= 3000`
- The path contains only English letters, digits, periods `.`, slashes `/`, or underscores `_`.
- The input is a valid absolute Unix path.

---

## 💡 Approach

- Use a **stack** to simulate directory navigation.
- Split the path by `/`.
- For each part:
  - Ignore `.` and empty strings.
  - Use `pop` on `..` to go back.
  - Otherwise, push valid folder names onto the stack.
- Join stack elements with `/` to form the final path.

---

## 💻 Java Solution

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();
        String[] st = path.split("/");

        for (String ch : st) {
            if (ch.equals("..")) {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            } else if (ch.equals(".") || ch.equals("")) {
                continue;
            } else {
                st1.push(ch);
            }
        }

        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        StringBuilder sb = new StringBuilder("/");
        while (!st2.isEmpty()) {
            sb.append(st2.pop());
            if (!st2.isEmpty()) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
