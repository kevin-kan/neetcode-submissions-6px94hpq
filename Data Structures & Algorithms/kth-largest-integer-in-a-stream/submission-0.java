class KthLargest {
    PriorityQueue<Integer> minHeap;
    int cap;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.cap = k;
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > cap) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
