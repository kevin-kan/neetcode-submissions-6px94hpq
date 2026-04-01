class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();

        if (intervals.length > 0) {
            merged.add(intervals[0]);
        }
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= merged.get(merged.size() -1)[1]) {
                merged.get(merged.size() -1)[1] = Math.max(intervals[i][1], merged.get(merged.size() -1)[1]);
            }
            else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][2]);
    }
}
