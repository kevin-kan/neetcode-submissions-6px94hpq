class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;

        while (l < r) {
            // One side will always be sorted
            // the minimum lies at the rotation point in the unsorted side.
            int m = l + (r-l)/2;
            // if right side sorted, minimum will be on the left side
            if (nums[m] < nums[r]) {
                r = m;
            }
            // if left side is sorted, minimum will be on the right
            else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
