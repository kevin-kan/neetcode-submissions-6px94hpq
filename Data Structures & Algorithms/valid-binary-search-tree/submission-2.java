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
    /**
     * DFS Solution
     * Time Complexity: O(n)
     * Space Complexity: O(n) -> in the call stack 
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode currentNode, int min, int max) {
        // Base case for null node
        if (currentNode == null) return true;
        // Check yourself
        if (currentNode.val >= max || currentNode.val <= min) return false;
        // Check your children
        return isValidBST(currentNode.left, min, currentNode.val) && 
                isValidBST(currentNode.right, currentNode.val, max);
    }

}
