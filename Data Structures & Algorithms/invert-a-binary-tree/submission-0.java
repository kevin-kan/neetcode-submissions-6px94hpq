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
     * BFS Iterative Approach:
     * Time Complexity: O(N) where N is the number of nodes in the binary tree.
     * We visit each node exactly once to invert the tree.
     * Space Complexity: O(W) where W is the maximum width of the binary tree.
     * The space complexity is determined by the queue used for BFS traversal, which in the worst case can hold all nodes at the widest level of the tree.
     * Same can be implemented using Deque/Stack as well for an iterative DFS approach.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // Create a queue for BFS traversal and start it off with the root
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to the queue for further processing
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return root;
    }
}
