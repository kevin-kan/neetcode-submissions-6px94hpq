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
     * Recursive DFS Solution
     * We need to process this bottom up, or else it'll be O(n^2) speed due to getting the height at each node on our way down
     * Time Complexity: O(n) 
     * Space Complexity: O(n)
     */
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private TreeInfo checkBalance(TreeNode root) {
        // Base Case: Tree is null
        if (root == null) return new TreeInfo(true, 0);

        // Tree is unbalanced as soon as either child is unbalanced.
        TreeInfo leftInfo = checkBalance(root.left);
        if (!leftInfo.isBalanced) return leftInfo;
        TreeInfo rightInfo = checkBalance(root.right);
        if (!rightInfo.isBalanced) return rightInfo;

        return new TreeInfo(
            Math.abs(leftInfo.height - rightInfo.height) <= 1,
            Math.max(leftInfo.height, rightInfo.height) + 1
        );
    }

    private class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
