<body>

  <h1>🔁 <a href="https://leetcode.com/problems/design-circular-queue/">622. Design Circular Queue</a></h1>

  <p>
    Implement a circular queue, also known as a ring buffer. It operates on the FIFO principle but wraps around when the end of the queue is reached, efficiently using available space.
  </p>

  <h2>🧠 Key Idea</h2>
  <p>
    Unlike a normal queue, which becomes unusable once full, a circular queue connects the last index to the first, enabling continuous usage of array space.
  </p>

  <h2>📌 Supported Operations</h2>
  <ul>
    <li><code>MyCircularQueue(k)</code>: Initializes the queue of size <code>k</code>.</li>
    <li><code>boolean enQueue(int value)</code>: Adds <code>value</code> to rear. Returns <code>true</code> if successful.</li>
    <li><code>boolean deQueue()</code>: Removes front element. Returns <code>true</code> if successful.</li>
    <li><code>int Front()</code>: Gets the front item. Returns <code>-1</code> if empty.</li>
    <li><code>int Rear()</code>: Gets the rear item. Returns <code>-1</code> if empty.</li>
    <li><code>boolean isEmpty()</code>: Returns true if queue is empty.</li>
    <li><code>boolean isFull()</code>: Returns true if queue is full.</li>
  </ul>

  <h2>💡 Implementation (Java)</h2>
  <pre><code>class MyCircularQueue {
   int[] arr;
   int front = 0;
   int rear = -1;
   int size = 0;

   public MyCircularQueue(int k) {
       arr = new int[k];
   }

   public boolean enQueue(int value) {
       if (size == arr.length) return false;
       rear = (rear + 1) % arr.length;
       arr[rear] = value;
       size++;
       return true;
   }

   public boolean deQueue() {
       if (size == 0) return false;
       front = (front + 1) % arr.length;
       size--;
       return true;
   }

   public int Front() {
       return size == 0 ? -1 : arr[front];
   }

   public int Rear() {
       return size == 0 ? -1 : arr[rear];
   }

   public boolean isEmpty() {
       return size == 0;
   }

   public boolean isFull() {
       return size == arr.length;
   }
}</code></pre>

  <h2>🔍 How It Works</h2>
  <ul>
    <li>We maintain <code>front</code> and <code>rear</code> pointers using modulo arithmetic to wrap around the array.</li>
    <li><code>size</code> tracks the number of elements to avoid collision between full and empty states.</li>
  </ul>

  <h2>⏱️ Time & Space Complexity</h2>
  <ul>
    <li><strong>Time Complexity:</strong> O(1) for all operations.</li>
    <li><strong>Space Complexity:</strong> O(k), where k is queue capacity.</li>
  </ul>

  <h2>🧪 Sample Test Case</h2>
  <pre><code>Input:
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", 
 "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]

Output:
[null, true, true, true, false, 3, true, true, true, 4]</code></pre>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Inserting when full returns false.</li>
    <li>Dequeuing when empty returns false.</li>
    <li>Getting front or rear from empty queue returns -1.</li>
  </ul>

</body>
