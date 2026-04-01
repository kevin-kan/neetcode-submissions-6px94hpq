class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        int m, mid;

        while (l <= r) {
            m = ((r - l) / 2) + l;
            mid = nums[m];
            if (mid == target) {
                return m;
            }
            if (mid > target) {
                r--;
            }
            if (mid < target) {
                l++;
            }
        }
        return -1;
    }
}
