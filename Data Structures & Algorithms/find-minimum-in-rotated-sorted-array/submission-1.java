class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int midIdx, midVal;

        while (left < right) {
            midIdx = ((right - left) / 2) + left;
            midVal = nums[midIdx];
            if (midVal < nums[right]) {
                // right sorted, but minimum is on the left
                right = midIdx;
            } else {
                // left sorted, but minimum is on the right
                left = midIdx + 1;
            }

        }

        return nums[left];
    }
}
