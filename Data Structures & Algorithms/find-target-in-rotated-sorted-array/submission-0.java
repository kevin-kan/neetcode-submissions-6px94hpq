class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int midIdx, midVal;

        while (left <= right) {
            midIdx = ((right - left) / 2) + left;
            midVal = nums[midIdx];
            if (midVal == target) {
                return midIdx;
            }
            if (midVal >= nums[left]) {
                // then left side is sorted
                if (target >= nums[left] && target <= midVal) {
                    right = midIdx;
                } else {
                    left = midIdx +1;
                }
            } else {
                // then right side is sorted
                if (target <= nums[right] && target >= midVal) {
                    left = midIdx + 1;
                } else {
                    right = midIdx;
                }
            }
        }

        return -1;
    }
}
