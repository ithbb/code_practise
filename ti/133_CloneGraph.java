/*
// Definition for a Node.
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
        if (node == null || node.neighbors == null) {
            return node;
        }
        Map<Node, Node> visited = new HashMap<Node, Node>();
        Node newNode = cloneNode(node, visited);
        return newNode;
    }

    public Node cloneNode(Node node, Map<Node, Node> visited) {
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        if (node.neighbors != null && node.neighbors.size() > 0) {
            for (Node neighbor : node.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    Node newNeighbor = cloneNode(neighbor, visited);
                    newNode.neighbors.add(newNeighbor);
                } else {
                   newNode.neighbors.add(visited.get(neighbor));
                }
            }
        }
        return newNode;
    }
}
