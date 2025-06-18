<body>

  <h1>🔁 <a href="https://leetcode.com/problems/design-circular-deque/">641. Design Circular Deque</a></h1>

  <p>
    Design and implement a circular double-ended queue (deque). Your implementation should support insertions and deletions at both front and rear ends efficiently.
  </p>

  <h2>🛠️ Class Definition</h2>
  <pre><code>MyCircularDeque(int k)</code> – Initializes the deque with a maximum size of <code>k</code>.</pre>

  <h2>📌 Supported Operations</h2>
  <ul>
    <li><code>boolean insertFront(int value)</code>: Adds item to the front. Returns true if successful.</li>
    <li><code>boolean insertLast(int value)</code>: Adds item to the rear. Returns true if successful.</li>
    <li><code>boolean deleteFront()</code>: Deletes item from front. Returns true if successful.</li>
    <li><code>boolean deleteLast()</code>: Deletes item from rear. Returns true if successful.</li>
    <li><code>int getFront()</code>: Returns front item or -1 if deque is empty.</li>
    <li><code>int getRear()</code>: Returns rear item or -1 if deque is empty.</li>
    <li><code>boolean isEmpty()</code>: Returns true if deque is empty.</li>
    <li><code>boolean isFull()</code>: Returns true if deque is full.</li>
  </ul>

  <h2>💡 Implementation (Java)</h2>
  <pre><code>class MyCircularDeque {
    int[] arr;
    int front, rear, size, length;

    public MyCircularDeque(int k) {
        arr = new int[k];
        length = k;
        front = 0;
        rear = k - 1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + length) % length;
        arr[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % length;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + length) % length;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : arr[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }
}</code></pre>

  <h2>🧠 How It Works</h2>
  <ul>
    <li>The deque is implemented using a circular array with modular arithmetic for index wrapping.</li>
    <li><code>front</code> points to the actual front of the deque, and <code>rear</code> points to the actual rear.</li>
    <li>Insertion or deletion updates the respective pointer using modulo operations to wrap around.</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong> O(1) for all operations.</li>
    <li><strong>Space Complexity:</strong> O(k), where <code>k</code> is the size of the deque.</li>
  </ul>

  <h2>🧪 Example Execution</h2>
  <pre><code>Input:
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", 
 "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]

Output:
[null, true, true, true, false, 2, true, true, true, 4]</code></pre>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Trying to insert into a full deque returns false.</li>
    <li>Trying to delete from an empty deque returns false.</li>
    <li><code>getFront()</code> and <code>getRear()</code> return -1 when empty.</li>
  </ul>

</body>
