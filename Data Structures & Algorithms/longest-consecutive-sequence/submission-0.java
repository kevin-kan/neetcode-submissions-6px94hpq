class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int current, longest = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                current = num+1;
                while (numSet.contains(current)) {
                    current++;
                }
                longest = Math.max(longest, current - num);
            }
        }
        return longest;
    }
}
