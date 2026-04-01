class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(nums, 0, output, new ArrayList<>());
        return output;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> output, List<Integer> current) {
        output.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, output, current);
            current.remove(current.size() - 1);
        }

    }
}
