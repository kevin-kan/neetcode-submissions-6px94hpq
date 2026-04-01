class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int sum;

        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1}; // Question requires 1-indexed solution
            }
            else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1}; // { -1, -1 } for solution not found, but Question asserts exactly 1 valid solution.
    }
}
