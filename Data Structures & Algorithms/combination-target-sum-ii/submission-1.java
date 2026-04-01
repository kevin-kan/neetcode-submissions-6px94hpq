class Solution {

    /**
     * Backtracking approach
     * Time Complexity: O(N^(T/M + 1)) where N is the number of candidates, T is the target, and M is the minimum value in candidates.
     * Space Complexity: O(T/M) where T is the target, and M is the minimum value in candidates.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // If we were skipping duplicates:
        Arrays.sort(candidates);
        // Set up a result list and current combination list to track progress
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> currentCombo, List<List<Integer>> result) {
        // If we've hit the target, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(currentCombo));
            return;
        }
        // If we've exceeded the target, no need to continue
        else if (target < 0) {
            return;
        }
        // Iterate through candidates starting from the current index
        for (int i = index; i < candidates.length; i++) {
            // If we were skipping duplicates:
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // Include the candidate and continue the search with the updated target
            currentCombo.add(candidates[i]);
            
            // If we were skipping duplicates:
            backtrack(candidates, target - candidates[i], i + 1, currentCombo, result);
            // backtrack(candidates, target - candidates[i], i, currentCombo, result); 
            
            // Backtrack: remove the last added candidate in order to try the next candidate
            currentCombo.remove(currentCombo.size() - 1);
        }
    }
}
