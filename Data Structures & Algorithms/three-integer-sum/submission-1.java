class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length -1;
        int sum;
        for (int i = 0; i < nums.length -2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            l = i+1; r = nums.length-1;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    output.add(new ArrayList<>(temp));
                    l++; r--;
                    while (l < r && nums[l] == nums[l-1]) l++;
                }
                if (sum > 0) r--;
                if (sum < 0) l++;
            }

        }
        return output;
    }
}
