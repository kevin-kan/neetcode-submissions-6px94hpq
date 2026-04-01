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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultingList = new ArrayList<>();

        dfs(root, 0, resultingList);

        return resultingList;
    }

    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;

        if (res.size() == depth) {
            res.add(node.val);
        }

        dfs(node.right, depth +1, res);
        dfs(node.left, depth +1, res);
    }
}
