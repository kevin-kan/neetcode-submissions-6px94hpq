class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            Integer stone1 = maxHeap.poll();
            Integer stone2 = maxHeap.poll();

            if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            }
            else if (stone2 > stone1) {
                maxHeap.offer(stone2 - stone1);
            }
        }

        return (maxHeap.size() == 1) ? maxHeap.poll() : 0;
        
    }
}
