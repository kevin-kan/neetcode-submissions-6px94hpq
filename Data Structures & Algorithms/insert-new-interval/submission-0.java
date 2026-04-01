class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newIntervals = new ArrayList<>();

        int i = 0; // Interval Index Num  
        // Add all the intervals up to the new interval (ends before new interval starts)
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i]);
            i++;
        }

        // Merge all the overlapping intervals:
        // ends after new interval starts and up to 
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        newIntervals.add(newInterval);

        // Add all the intervals after the new interval (starts after new interval ends)
        while (i < intervals.length) {
            newIntervals.add(intervals[i]);
            i++;
        }

        return newIntervals.toArray(new int[newIntervals.size()][]);
    }
}
