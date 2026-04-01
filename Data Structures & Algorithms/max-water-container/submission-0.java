class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int area, maxArea = 0;

        while (left < right) {
            area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(area, maxArea);
            if (heights[left] > heights[right]) right--;
            else left++;
        }

        return maxArea;
    }
}
