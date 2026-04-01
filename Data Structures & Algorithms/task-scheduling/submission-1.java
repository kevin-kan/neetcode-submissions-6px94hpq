class Solution {
    public int leastInterval(char[] tasks, int n) {
        int cpuCycles = 0;

        // Count the frequencies of each Task:
        Map<Character, Integer> taskFreq = new HashMap<>();
        for (char task : tasks) {
            taskFreq.put(task, taskFreq.getOrDefault(task, 0) + 1);
        }
        // Load those characters into a Priority Queue for Processing:
        PriorityQueue<TaskFrequency> maxHeap = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        for (Map.Entry<Character, Integer> e : taskFreq.entrySet()) {
            maxHeap.offer(new TaskFrequency(e.getKey(), e.getValue()));
        }

        // Process the Priority Queue:
        Deque<TaskFrequency> q = new ArrayDeque<>();
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            cpuCycles++;

            if (!maxHeap.isEmpty()) {
                TaskFrequency t = maxHeap.poll();
                // Process the task
                t.frequency--;

                // Put the task into timeout (if there's any left)
                if (t.frequency > 0) {
                    t.nextCycle = cpuCycles + n;
                    q.offer(t);
                }
            } else {
                // If main queue is empty, then fast forward time to the next item in wait queue.
                cpuCycles = q.peek().nextCycle;
            }

            // Move items from timeout back into the priority queue.
            while (!q.isEmpty() && q.peek().nextCycle <= cpuCycles) {
                maxHeap.add(q.poll());
            }
            
        }
        
        return cpuCycles;
    }

}

class TaskFrequency {
    char task;
    int frequency;
    int nextCycle;
    
    public TaskFrequency(char task, int frequency) {
        this.task = task;
        this.frequency = frequency;
        this.nextCycle = -1;
    }
}
