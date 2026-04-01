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

public class Codec { // Serialize and Deserialize Binary Tree


    /**
     * Encodes a tree to a single string
     * @param root root of the Tree
     * @return comma-separated PreOrder traversal of the tree. ie. "1,2,3"
     */
    public String serialize(TreeNode root) {
        Stack<String> preOrder = new Stack<>();
        // Fast Return for empty tree
        if (root == null) return "";

        // Use Queue instead of Deque to allow null values. 
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while (!bfsQueue.isEmpty()) {
            // Pop the current node for processing
            TreeNode curr = bfsQueue.poll();
            if (curr != null) {
                // Add the current node value to the output stack
                preOrder.add(String.valueOf(curr.val));
                // Add the child nodes to the processing queue 
                bfsQueue.offer(curr.left);
                bfsQueue.offer(curr.right);
            } else {
                // Add "null" to the output stack if the node is null.
                preOrder.add("null");
            }
        }
        
        // Clear the trailing "null" values
        while(preOrder.peek().equals("null")) {
            preOrder.pop();
        }
        // Join the stack with a comma and return
        return String.join(",", preOrder);
    }


    /**
     * Decodes your encoded data to tree.
     * @param data "1,2,3"
     * @return root of the Tree
     */
    public TreeNode deserialize(String data) {
        // Quick return if we've got no data to deserialize
        if (data.isBlank()) return null;
        
        // Break the string into individual values
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        int valIndex = 1;

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        while (!bfsQueue.isEmpty()) {
            // Pop the current node for processing
            TreeNode curr = bfsQueue.poll();
            if (valIndex < vals.length && !vals[valIndex].equals("null")) {
                // Create a new node for the non-null object
                curr.left = new TreeNode(Integer.parseInt(vals[valIndex]));
                // Add it to the queue
                bfsQueue.add(curr.left);
            }
            valIndex++;
            if (valIndex < vals.length && !vals[valIndex].equals("null")) {
                // Create a new node for the non-null object
                curr.right = new TreeNode(Integer.parseInt(vals[valIndex]));
                // Add it to the queue
                bfsQueue.add(curr.right);
            }
            valIndex++;
        }
        return root;
    }
}
