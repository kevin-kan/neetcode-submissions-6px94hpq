/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        // Create array to hold the best diameter so we can pass it and update (can also be done with global variable)
        int[] bestDiameter = new int[1];

        // call dfs to update best diameter as we dfs through the bst and calculate the depth; 
        dfs(root, bestDiameter);

        // return the updated bestDiameter.
        return bestDiameter[0];
    }

    private int dfs(TreeNode root, int[] bestDiameter) {
        // Base case: if we hit the end, return 0 - no depth
        if (root == null) return 0;

        // Perform dfs left and right to get the depth for the left and right, while updating the bestDiameter.
        int left = dfs(root.left, bestDiameter);
        int right = dfs(root.right, bestDiameter);

        // Update bestDiameter with the left+right depth if it's better
        bestDiameter[0] = Math.max(bestDiameter[0], left+right);

        // Return the depth at this node in order to properly track the diameter. 
        return 1 + Math.max(left, right);
    }

}
