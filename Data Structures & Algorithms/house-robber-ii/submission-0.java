class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robHelp(nums, 0, nums.length-2), robHelp(nums, 1, nums.length-1));
    }

    public int robHelp(int[] nums, int startIndex, int endIndex) { // O(1) space
        int robBest1 = nums[startIndex];
        if ((endIndex - startIndex + 1) == 1) return robBest1;
        int robBest2 = Math.max(nums[startIndex], nums[startIndex+1]);
        int temp;

        for (int i = startIndex+2; i <= endIndex; i++) {
            temp = robBest1;
            robBest1 = robBest2;
            robBest2 = Math.max(temp + nums[i], robBest1);
        } 

        return robBest2;
    }
}