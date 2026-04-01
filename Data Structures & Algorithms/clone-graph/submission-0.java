/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visitedOldNew = new HashMap<>();

        return clone(node, visitedOldNew);
    }

    private Node clone(Node node, Map<Node,Node> visitedOldNew) {
        // Base Case: Edge
        if (node == null) return null;

        // Check cache if the node has already been visited
        if (visitedOldNew.containsKey(node)) {
            return visitedOldNew.get(node);
        }
        
        // Make the deep copy
        Node copy = new Node(node.val);
        visitedOldNew.put(node, copy);

        // Run clone again on its neighbors, and add them to this clone's neighbor
        for (Node n : node.neighbors) {
            copy.neighbors.add(clone(n, visitedOldNew));
        }

        return copy;
    }
}