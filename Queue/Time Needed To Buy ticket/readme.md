<body>

  <h1>⏳ <a href="https://leetcode.com/problems/time-needed-to-buy-tickets/">2073. Time Needed to Buy Tickets</a></h1>

  <p>
    You are given a queue of people where <code>tickets[i]</code> represents the number of tickets the <code>i<sup>th</sup></code> person wants to buy. Each person can only buy one ticket per turn and must go to the end of the line to buy another. Determine the total time in seconds for the person at position <code>k</code> to finish buying all their tickets.
  </p>

  <h2>📌 Solution Provided (Java)</h2>
  <pre><code>class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue&lt;int[]&gt; q = new LinkedList&lt;&gt;();

        for (int i = 0; i &lt; tickets.length; i++) {
            q.add(new int[] {tickets[i], i});
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int remaining = curr[0];
            int index = curr[1];
            time++;

            if (remaining - 1 &gt; 0) {
                q.add(new int[] {remaining - 1, index});
            }

            if (index == k &amp;&amp; remaining - 1 == 0) {
                break;
            }
        }

        return time;
    }
}</code></pre>

  <h2>🧠 Detailed Approach</h2>
  <ol>
    <li><strong>Use a Queue:</strong> Each element holds the number of tickets left and the person's original index.</li>
    <li><strong>While queue is not empty:</strong>
      <ul>
        <li>Poll the front person and decrement their ticket count.</li>
        <li>If they still have tickets to buy, reinsert them at the end.</li>
        <li>Increment a <code>time</code> counter for every operation.</li>
        <li>Stop when the target person (<code>index == k</code>) buys their last ticket.</li>
      </ul>
    </li>
  </ol>

  <h2>🔍 Why It Works</h2>
  <ul>
    <li>We simulate the real-time process of the queue by using a <code>Queue</code> structure to rotate buyers.</li>
    <li>Keeping track of the original index helps identify when the person at position <code>k</code> finishes.</li>
  </ul>

  <h2>⏱️ Complexity Analysis</h2>
  <ul>
    <li><strong>Time Complexity:</strong> O(n × m), where:
      <ul>
        <li><code>n</code> = number of people in queue</li>
        <li><code>m</code> = maximum number of tickets any person wants</li>
      </ul>
    </li>
    <li><strong>Space Complexity:</strong> O(n) for the queue storage</li>
  </ul>

  <h2>✅ Edge Cases</h2>
  <ul>
    <li>Single person: <code>tickets = [x], k = 0</code> ⇒ time = x seconds</li>
    <li>Everyone needs the same number of tickets</li>
    <li>Target person at the end of the queue</li>
  </ul>

  <h2>🔄 Alternate Solution (Optimized)</h2>
  <p>
    We can compute the total time without simulating the queue:
    </p>
  <pre><code>public int timeRequiredToBuy(int[] tickets, int k) {
    int time = 0;
    for (int i = 0; i &lt; tickets.length; i++) {
        if (i &lt;= k) time += Math.min(tickets[i], tickets[k]);
        else time += Math.min(tickets[i], tickets[k] - 1);
    }
    return time;
}</code></pre>
  <p>This avoids the overhead of using a queue and improves performance to O(n).</p>

</body>
