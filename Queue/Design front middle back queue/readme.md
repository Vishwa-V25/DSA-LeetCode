<body>

  <h1>🔀 <a href="https://leetcode.com/problems/design-front-middle-back-queue/">1670. Design Front Middle Back Queue</a></h1>

  <p>
    Implement a queue that allows insertion and deletion from the front, middle, and back in <code>O(1)</code> to <code>O(log N)</code> time using two deques.
  </p>

  <h2>🧠 Key Idea</h2>
  <p>
    Maintain two deques:
    <ul>
      <li><strong>front:</strong> Holds the left half of elements</li>
      <li><strong>back:</strong> Holds the right half of elements</li>
    </ul>
    Always balance them such that:
    <code>front.size() == back.size()</code> or <code>front.size() == back.size() - 1</code>
  </p>

  <h2>📌 Supported Operations</h2>
  <ul>
    <li><code>pushFront(val)</code>: Add to front of <code>front</code>.</li>
    <li><code>pushMiddle(val)</code>: Add to the end of <code>front</code> so that it becomes the front middle.</li>
    <li><code>pushBack(val)</code>: Add to back of <code>back</code>.</li>
    <li><code>popFront()</code>: Remove from <code>front</code>, or if empty, from <code>back</code>.</li>
    <li><code>popMiddle()</code>: 
      <ul>
        <li>If even, remove last of <code>front</code></li>
        <li>If odd, remove first of <code>back</code></li>
      </ul>
    </li>
    <li><code>popBack()</code>: Remove from <code>back</code>.</li>
  </ul>

  <h2>💡 Java Implementation</h2>
  <pre><code>class FrontMiddleBackQueue {
    Deque&lt;Integer&gt; front, back;

    public FrontMiddleBackQueue() {
        front = new LinkedList&lt;&gt;();
        back = new LinkedList&lt;&gt;();
    }

    private void balance() {
        while (front.size() > back.size()) {
            back.addFirst(front.removeLast());
        }
        while (back.size() > front.size() + 1) {
            front.addLast(back.removeFirst());
        }
    }

    public void pushFront(int val) {
        front.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        front.addLast(val);
        balance();
    }

    public void pushBack(int val) {
        back.addLast(val);
        balance();
    }

    public int popFront() {
        if (front.isEmpty() && back.isEmpty()) return -1;

        int val;
        if (!front.isEmpty()) {
            val = front.removeFirst();
        } else {
            val = back.removeFirst();
        }
        balance();
        return val;
    }

    public int popMiddle() {
        if (front.isEmpty() && back.isEmpty()) return -1;

        int val;
        if (front.size() == back.size()) {
            val = front.removeLast();
        } else {
            val = back.removeFirst();
        }
        balance();
        return val;
    }

    public int popBack() {
        if (front.isEmpty() && back.isEmpty()) return -1;

        int val = back.removeLast();
        balance();
        return val;
    }
}</code></pre>

  <h2>🔍 Explanation with Example</h2>
  <pre><code>Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle",
 "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]

Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]</code></pre>

  <h2>⚖️ Balance Logic</h2>
  <p>
    After every push or pop, ensure:
    <code>
    front.size() == back.size() OR front.size() == back.size() - 1
    </code>
  </p>

  <h2>⏱️ Time & Space Complexity</h2>
  <ul>
    <li><strong>Time:</strong> O(1) amortized for all operations</li>
    <li><strong>Space:</strong> O(n), where n is number of elements</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>All pop operations return <code>-1</code> if queue is empty</li>
    <li>Middle prefers front-middle if even number of elements</li>
  </ul>

</body>
