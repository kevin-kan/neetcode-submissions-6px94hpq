class Solution {
    /**
     * Backtracking approach
     * Time Complexity: O(n * 2^n) where n is the length of the nums array.
     * Space Complexity: O(n * 2^n) for the recursion stack.  
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        // SKIP DUPLICATES ADDITION - DIFFERENCE BETWEEN SUBSETS AND SUBSETS II
        // Sorting the array puts all duplicates beside each other (easier to skip)
        Arrays.sort(nums);
        backtrack(nums, 0, subset, result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // Add the last subset of items to the result. 
        result.add(new ArrayList<>(subset));

        // Iterate through from index to nums.length - 1 to add all combinations of the subset.
        for (int i = index; i < nums.length; i++) {

            // SKIP DUPLICATES ADDITION - DIFFERENCE BETWEEN SUBSETS AND SUBSETS II
            // Skip If:
            // 1. we've moved past the original index
            // 2. the current element is the same as the previous one.
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }

            // CHOOSE: Include nums[i]
            subset.add(nums[i]);
            // EXPLORE: Move to the next element
            // Use i+1 because we cannot reuse the same element and want to maintain order (avoid duplicates)
            backtrack(nums, i + 1, subset, result);
            // UNCHOOSE: Remove nums[i] to try other paths.
            subset.remove(subset.size() - 1);
        }

    }
}
