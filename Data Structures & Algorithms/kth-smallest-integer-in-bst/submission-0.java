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
     * In Order DFS Approach
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        kthSmallest_helper(root, inOrder);

        return inOrder.get(k - 1);
    }

    private void kthSmallest_helper(TreeNode node, List<Integer> inOrder) {
        if (node == null) return;

        kthSmallest_helper(node.left, inOrder);
        inOrder.add(node.val);
        kthSmallest_helper(node.right, inOrder);
    }
}
