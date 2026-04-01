class Solution {
    // public int rob(int[] nums) {
    //     int[] robBest = new int[nums.length];

    //     robBest[0] = nums[0];
    //     robBest[1] = Math.max(nums[0], nums[1]);

    //     for (int i = 2; i < nums.length; i++) {
    //         robBest[i] = Math.max(robBest[i-2] + nums[i], robBest[i-1]);
    //     } 

    //     return robBest[nums.length-1];
    // }

    public int rob(int[] nums) { // O(1) space
        int robBest1 = nums[0];
        if (nums.length == 0) return 0;
        if (nums.length == 1) return robBest1;
        int robBest2 = Math.max(nums[0], nums[1]);
        int temp;

        for (int i = 2; i < nums.length; i++) {
            temp = robBest1;
            robBest1 = robBest2;
            robBest2 = Math.max(temp + nums[i], robBest1);
        } 

        return robBest2;
    }
}
